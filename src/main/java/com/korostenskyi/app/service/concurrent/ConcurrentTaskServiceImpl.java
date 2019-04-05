package com.korostenskyi.app.service.concurrent;

import com.korostenskyi.app.data.entity.Book;
import com.korostenskyi.app.data.entity.Character;
import com.korostenskyi.app.data.entity.House;
import com.korostenskyi.app.data.network.NetworkDataSource;
import com.korostenskyi.app.data.repository.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

@Service
public class ConcurrentTaskServiceImpl implements ConcurrentTaskService {

    private final int THREAD_COUNT = 5;
    private final NetworkDataSource networkDataSource;
    private CharacterRepository characterRepository;

    private Logger logger;
    private ExecutorService executorService;

    @Autowired
    public ConcurrentTaskServiceImpl(NetworkDataSource networkDataSource) {
        this.networkDataSource = networkDataSource;

        logger = LoggerFactory.getLogger(ConcurrentTaskServiceImpl.class);
        executorService = Executors.newFixedThreadPool(THREAD_COUNT);
    }

    @Autowired
    public void setCharacterRepository(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public void stopService() {

        try {

            logger.info("Attempt to shutdown task executor.");

            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            logger.warn("Stopping the task executor was interrupted.");
        } finally {

            if (!executorService.isTerminated()) {
                logger.error("Cancelling non-finished tasks.");
            }

            executorService.shutdownNow();

            logger.info("Task executor service is dead now -_-");
        }
    }

    @Override
    public Future<Book> getBookById(Long id) {

        Callable<Book> task = () -> networkDataSource.getBookById(id);

        return executorService.submit(task);
    }

    @Override
    public Future<Character> getCharacterById(Long id) {

        Callable<Character> task = () -> networkDataSource.getCharacterById(id);

        return executorService.submit(task);
    }

    @Override
    public Future<House> getHouseById(Long id) {

        Callable<House> task = () -> networkDataSource.getHouseById(id);

        return executorService.submit(task);
    }

    @Override
    public Future<Character> fetchCharacterByIdFromDatabase(Long id) {

        Callable<Character> task = () -> characterRepository.findById(id).orElse(null);

        return executorService.submit(task);
    }

    @Override
    public Future<Iterable<Character>> fetchAllCharactersFromDatabase() {

        Callable<Iterable<Character>> task = () -> characterRepository.findAll();

        return executorService.submit(task);
    }
}

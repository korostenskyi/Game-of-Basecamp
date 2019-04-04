package com.korostenskyi.app.service.main;

import com.korostenskyi.app.data.entity.Book;
import com.korostenskyi.app.data.entity.House;
import com.korostenskyi.app.data.repository.BookRepository;
import com.korostenskyi.app.data.repository.CharacterRepository;
import com.korostenskyi.app.data.repository.HouseRepository;
import com.korostenskyi.app.service.concurrent.ConcurrentTaskService;
import com.korostenskyi.app.wire.MessageResponse;
import com.korostenskyi.app.data.entity.Character;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class MainServiceImpl implements MainService {

    private final ConcurrentTaskService taskService;

    private BookRepository bookRepository;
    private CharacterRepository characterRepository;
    private HouseRepository houseRepository;

    private Logger logger;

    @Autowired
    public MainServiceImpl(ConcurrentTaskService taskService) {
        this.taskService = taskService;

        logger = LoggerFactory.getLogger(MainServiceImpl.class);
    }


    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void setCharacterRepository(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Autowired
    public void setHouseRepository(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public MessageResponse postCharacter(Long id) {
        return new MessageResponse(HttpStatus.OK, "Posted user with id of" + id);
    }

    @Override
    public MessageResponse greetUser() {
        return new MessageResponse(HttpStatus.OK, "Hello!");
    }

    @Override
    public MessageResponse fight(Long id) {
        return new MessageResponse(HttpStatus.OK, "МАХАЧ");
    }

    @Override
    public Book getBookById(Long id) {

        Book book = null;

        try {
            book = taskService.getBookById(id).get();
            bookRepository.save(book);

            logger.info("Book saved");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public Character getCharacterById(Long id) {

        Character character = null;

        try {
            character = taskService.getCharacterById(id).get();
            characterRepository.save(character);

            logger.info("Character saves");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return character;
    }

    @Override
    public House getHouseById(Long id) {

        House house = null;

        try {
            house = taskService.getHouseById(id).get();
            houseRepository.save(house);

            logger.info("House saved");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return house;
    }

    @Override
    public void stopExecutor() {

        logger.warn("Telling the task executor to stop...");

        taskService.stopService();

        logger.info("Task executor is stopped");
    }
}

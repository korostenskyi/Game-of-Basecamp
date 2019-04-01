package com.korostenskyi.app.service.main;

import com.korostenskyi.app.data.entity.Book;
import com.korostenskyi.app.data.entity.House;
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

    private Logger logger;

    @Autowired
    public MainServiceImpl(ConcurrentTaskService taskService) {
        this.taskService = taskService;

        logger = LoggerFactory.getLogger(MainServiceImpl.class);
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

        try {
            return taskService.getBookById(id).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Character getCharacterById(Long id) {

        try {
            return taskService.getCharacterById(id).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public House getHouseById(Long id) {

        try {
            return taskService.getHouseById(id).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void stopExecutor() {

        logger.warn("Telling the task executor to stop...");

        taskService.stopService();

        logger.info("Task executor is stopped");
    }
}

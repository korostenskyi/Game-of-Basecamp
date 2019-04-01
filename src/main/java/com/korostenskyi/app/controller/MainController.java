package com.korostenskyi.app.controller;

import com.korostenskyi.app.data.entity.Book;
import com.korostenskyi.app.data.entity.Character;
import com.korostenskyi.app.data.entity.House;
import com.korostenskyi.app.service.main.MainService;
import com.korostenskyi.app.wire.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class MainController {

    private final MainService mainService;

    private Logger logger;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;

        logger = LoggerFactory.getLogger(MainController.class);
    }

    @GetMapping(value = "/", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> greetUser() {

        logger.info("Greet user");

        return ResponseEntity.ok().body(mainService.greetUser());
    }

    @GetMapping(value = "/{UUID}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<MessageResponse> fight(@PathVariable Long UUID) {

        logger.info("Махач");

        return ResponseEntity.ok().body(mainService.fight(UUID));
    }

    @GetMapping(value = "/book/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {

        logger.info("Fetching book with id of " + id);

        return ResponseEntity.ok().body(mainService.getBookById(id));
    }

    @GetMapping(value = "/character/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Character> getCharacterById(@PathVariable Long id) {

        logger.info("Fetching character with id of " + id);

        return ResponseEntity.ok().body(mainService.getCharacterById(id));
    }

    @GetMapping(value = "/houses/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<House> getHouseById(@PathVariable Long id) {

        logger.info("Fetching house with id of " + id);

        return ResponseEntity.ok().body(mainService.getHouseById(id));
    }
}

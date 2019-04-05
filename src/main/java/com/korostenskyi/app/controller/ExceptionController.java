package com.korostenskyi.app.controller;

import com.korostenskyi.app.exception.NoSuchElementException;
import com.korostenskyi.app.wire.response.MessageResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<MessageResponse> recourseNotFound(ConstraintViolationException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new MessageResponse(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<MessageResponse> invalidInfo(NoSuchElementException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new MessageResponse(HttpStatus.NOT_FOUND, e.getMessage()));
    }
}

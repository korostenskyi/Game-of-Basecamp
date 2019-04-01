package com.korostenskyi.app.exception;

public class NoSuchElementException extends BaseException {

    private static final String ERROR = "Fetching error. ";

    public NoSuchElementException(String message) {
        super(ERROR + message);
    }

    public NoSuchElementException(String format, Object... args) {
        super(format, args);
    }
}

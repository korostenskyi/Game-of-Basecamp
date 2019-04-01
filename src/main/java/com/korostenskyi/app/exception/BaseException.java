package com.korostenskyi.app.exception;

public class BaseException extends RuntimeException {

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String format, Object... args) {
        super(String.format(format, args));
    }
}

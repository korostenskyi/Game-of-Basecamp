package com.korostenskyi.app.exception;

public class NoConnectionException extends BaseException {

    private static final String ERROR = "Fetching error. ";

    public NoConnectionException(String message) {
        super(ERROR + message);
    }

    public NoConnectionException(String format, Object... args) {
        super(format, args);
    }
}

package com.noteapp.exceptions;

public class ApiRequestExcaption extends RuntimeException {

    public ApiRequestExcaption(String message) {
        super(message);
    }

    public ApiRequestExcaption(String message, Throwable cause) {
        super(message, cause);
    }
}

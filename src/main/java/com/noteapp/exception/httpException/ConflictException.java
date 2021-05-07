package com.noteapp.exception.httpException;

import com.noteapp.exception.message.ApiExceptionJsonMessage;


public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }

    public ConflictException(ApiExceptionJsonMessage message) {
        super(message.getMassages());
    }
}

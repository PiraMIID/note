package com.noteapp.exception.httpException;

import com.noteapp.exception.helper.ApiExceptionJsonMessage;


public class ApiConflictException extends RuntimeException {
    public ApiConflictException(String message) {
        super(message);
    }

    public ApiConflictException(ApiExceptionJsonMessage message) {
        super(message.getMassages());
    }
}

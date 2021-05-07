package com.noteapp.exception.httpException;

import com.noteapp.exception.helper.ApiExceptionJsonMessageTool;


public class ApiConflictException extends RuntimeException {
    public ApiConflictException(ApiExceptionJsonMessageTool message) {
        super(message.getMassages());
    }
}

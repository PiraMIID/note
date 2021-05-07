package com.noteapp.exception.httpException;

import com.noteapp.exception.helper.ApiExceptionJsonMessage;


public class ApiRequestException extends RuntimeException {
    public ApiRequestException(ApiExceptionJsonMessage apiExceptionJsonMessage) {
        super(apiExceptionJsonMessage.getMassages());
    }
}

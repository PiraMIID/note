package com.noteapp.exception.httpException;

import com.noteapp.exception.message.ApiExceptionJsonMessage;


public class ApiRequestException extends RuntimeException  {
    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(ApiExceptionJsonMessage apiExceptionJsonMessage) {
        super(apiExceptionJsonMessage.getMassages());
        System.out.println(apiExceptionJsonMessage.getMassages() + "this");
    }
}

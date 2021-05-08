package com.noteapp.exception.httpException;


import com.noteapp.exception.helper.ApiExceptionJsonMessage;

public class ApiNotFoundException extends RuntimeException {
    public ApiNotFoundException(ApiExceptionJsonMessage e) {
        super(e.getMassages());
    }


}


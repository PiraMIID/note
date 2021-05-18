package com.noteapp.exception.httpException;


import com.noteapp.exception.helper.ApiExceptionJsonMessage;

public class ApiNotFoundException extends RuntimeException {
    public ApiNotFoundException(ApiExceptionJsonMessage e) {
        super(e.getMassages());
    }


    public ApiNotFoundException(String s1, String s2) {
        super(new ApiExceptionJsonMessage(s1,s2).getMassages());
    }
}


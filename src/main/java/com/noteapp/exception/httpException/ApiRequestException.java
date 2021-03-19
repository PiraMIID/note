package com.noteapp.exception.httpException;


import com.noteapp.exception.helper.ApiExceptionJsonMessage;


public class ApiRequestException extends RuntimeException {
    public ApiRequestException(String s1,String s2) {
        super(new ApiExceptionJsonMessage(s1,s2).getMassages());
    }
}

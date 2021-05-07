package com.noteapp.exception.httpException;


import com.noteapp.exception.helper.ApiExceptionJsonMessageTool;

public class ApiNotFoundException extends RuntimeException {
    public ApiNotFoundException(ApiExceptionJsonMessageTool e) {
        super(e.getMassages());
    }


}


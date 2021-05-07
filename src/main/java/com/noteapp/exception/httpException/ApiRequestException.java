package com.noteapp.exception.httpException;


import com.noteapp.exception.helper.ApiExceptionJsonMessageTool;


public class ApiRequestException extends RuntimeException {
    public ApiRequestException(ApiExceptionJsonMessageTool apiExceptionJsonMessageTool) {
        super(apiExceptionJsonMessageTool.getMassages());


    }
}

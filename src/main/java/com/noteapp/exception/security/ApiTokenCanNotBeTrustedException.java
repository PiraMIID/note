package com.noteapp.exception.security;

import com.noteapp.exception.helper.ApiExceptionJsonMessage;

public class ApiTokenCanNotBeTrustedException extends Exception {
    public ApiTokenCanNotBeTrustedException(ApiExceptionJsonMessage messages) {
        super(messages.getMassages());
    }
}

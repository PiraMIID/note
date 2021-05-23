package com.noteapp.exception.mail;

import com.noteapp.exception.helper.ApiExceptionJsonMessage;

public class ApiMailMessageException extends RuntimeException {

    public ApiMailMessageException(String s1, String s2) {
        super(new ApiExceptionJsonMessage(s1, s2).getMassages());
    }
}

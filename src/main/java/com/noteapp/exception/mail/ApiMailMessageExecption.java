package com.noteapp.exception.mail;

import com.noteapp.exception.helper.ApiExceptionJsonMessage;

public class ApiMailMessageExecption extends RuntimeException {
    public ApiMailMessageExecption(String s1, String s2) {
        super(new ApiExceptionJsonMessage(s1, s2).getMassages());
    }
}

package com.noteapp.exception.httpException;

import com.noteapp.exception.helper.ApiExceptionJsonMessage;

/**
 * @see ApiNotFoundException
 */
public class ApiConflictException extends RuntimeException {
    public ApiConflictException(ApiExceptionJsonMessage message) {
        super(message.getMassages());
    }

    public ApiConflictException(String objectName, String message) {
        ApiExceptionJsonMessage apiExceptionJsonMessage = new ApiExceptionJsonMessage(objectName, message);
        throw new ApiConflictException(apiExceptionJsonMessage);
    }
}

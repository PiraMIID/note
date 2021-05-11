package com.noteapp.exception.httpException;

import com.noteapp.exception.helper.ApiExceptionJsonMessage;

/**
 * @see ApiNotFoundException
 */
public class ApiConflictException extends RuntimeException {

    public ApiConflictException(ApiExceptionJsonMessage message) {
        super(message.getMassages());
    }
    /**
     * change massage to json format as String are used in:
     * @see com.noteapp.exception.controller.ApiControllerAdvice
     */
    public ApiConflictException(String objectName, String message) {
        super(
                new ApiExceptionJsonMessage(objectName, message)
                        .getMassages()
        );
    }
}

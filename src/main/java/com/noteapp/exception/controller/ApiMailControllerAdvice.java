package com.noteapp.exception.controller;


import com.noteapp.exception.httpException.ApiConflictException;
import com.noteapp.exception.mail.ApiMailMessageExecption;
import com.noteapp.exception.type.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springfox.documentation.spring.web.json.Json;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiMailControllerAdvice {

    @ExceptionHandler(value = ApiMailMessageExecption.class)
    public ResponseEntity<Object> handleApiConflictException(
            ApiMailMessageExecption e
    ) {
        Json message = new Json(e.getMessage());

        ApiException apiException =
                new ApiException(
                        HttpStatus.NO_CONTENT,
                        message,
                        ZonedDateTime.now());

        return new ResponseEntity<>(
                apiException,
                HttpStatus.NO_CONTENT);
    }
}

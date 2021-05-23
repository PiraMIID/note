package com.noteapp.exception.controller;

import com.noteapp.exception.type.ApiException;
import com.noteapp.exception.security.ApiTokenCanNotBeTrustedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springfox.documentation.spring.web.json.Json;


import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiSecurityControllerAdvice {

    @ExceptionHandler(value = ApiTokenCanNotBeTrustedException.class)
    public ResponseEntity<Object> tokenCanNotBeTrusted (
            ApiTokenCanNotBeTrustedException e
    ){
        System.out.println("jestem");
        System.out.println(e.getMessage());
        Json message = new Json(e.getMessage());

        ApiException apiException =
                new ApiException(
                        HttpStatus.FORBIDDEN,
                        message,
                        ZonedDateTime.now());

        return new ResponseEntity<>(
                apiException,
                HttpStatus.FORBIDDEN);
    }
}

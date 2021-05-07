package com.noteapp.exception.controller;

import com.noteapp.exception.confing.ApiException;

import com.noteapp.exception.httpException.ApiConflictException;
import com.noteapp.exception.httpException.ApiNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springfox.documentation.spring.web.json.Json;

import java.time.ZonedDateTime;




@ControllerAdvice
public class ApiControllerAdvice {


    @ExceptionHandler(value = ApiConflictException.class)
    public ResponseEntity<Object> handleApiConflictException(
            ApiConflictException e
    ) {
        Json message = new Json(e.getMessage());

        ApiException apiException =
                new ApiException(
                        HttpStatus.CONFLICT,
                        message,
                        ZonedDateTime.now());




    @ExceptionHandler(value = ApiNotFoundException.class)
    public ResponseEntity<Object> handleApiRequestException(
            ApiNotFoundException e
    ) {
        Json message = new Json(e.getMessage());

        ApiException apiException =
                new ApiException(
                        HttpStatus.NOT_FOUND,
                        message,
                        ZonedDateTime.now());

        return new ResponseEntity<>(
                apiException,
                HttpStatus.NOT_FOUND);
    }



}

package com.noteapp.exception.controller;

import com.noteapp.exception.confing.ApiException;
import com.noteapp.exception.httpException.ApiRequestException;
import com.noteapp.exception.httpException.ConflictException;
import com.noteapp.exception.message.ApiExceptionJsonMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import springfox.documentation.spring.web.json.Json;

import java.time.ZonedDateTime;
import java.util.Objects;


@ControllerAdvice
public class ApiControllerAdvice {
    @ExceptionHandler(value = ConflictException.class)
    public ResponseEntity<Object> handleApiRequestException(
            ApiRequestException e
    ) {
        System.out.println(e.getMessage() + "to tescić");
        Json message = new Json(e.getMessage());
        ApiException apiException = new ApiException(HttpStatus.CONFLICT, message, ZonedDateTime.now());
        return new ResponseEntity<>(
                apiException,
                HttpStatus.CONFLICT);
    }

    /*
     * method make message of valid type with annotation of the source
     *
     * */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleApiRequestArgumentNotValidException(BindingResult bindingResult) {
        System.out.println("to tescić");
        ApiExceptionJsonMessage apiExceptionJsonMessage = new ApiExceptionJsonMessage();
        apiExceptionJsonMessage.add(Objects.requireNonNull(bindingResult.getFieldError()).getField(), bindingResult.getFieldError().getDefaultMessage());
        Json message = new Json(apiExceptionJsonMessage.getMassages());
        ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST, message, ZonedDateTime.now());
        return new ResponseEntity<>(
                apiException,
                HttpStatus.BAD_REQUEST);
    }
}

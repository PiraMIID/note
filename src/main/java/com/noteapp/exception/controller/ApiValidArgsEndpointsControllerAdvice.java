package com.noteapp.exception.controller;

import com.noteapp.exception.confing.ApiException;
import com.noteapp.exception.helper.ApiExceptionJsonMessage;
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
public class ApiValidArgsEndpointsControllerAdvice {

    /*
     * when valid type with annotation of the source exception by @Valid
     * */

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleApiRequestArgumentNotValidException(BindingResult bindingResult) {

        ApiExceptionJsonMessage apiExceptionJsonMessage = new ApiExceptionJsonMessage();

        apiExceptionJsonMessage.add(
                Objects.requireNonNull(
                        bindingResult.getFieldError()).getField(),
                bindingResult.getFieldError().getDefaultMessage());

        Json message = new Json(apiExceptionJsonMessage.getMassages());

        ApiException apiException = new ApiException(
                HttpStatus.BAD_REQUEST,
                message,
                ZonedDateTime.now());

        return new ResponseEntity<>(
                apiException,
                HttpStatus.BAD_REQUEST);
    }
}

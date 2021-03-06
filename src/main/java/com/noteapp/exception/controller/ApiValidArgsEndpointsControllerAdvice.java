package com.noteapp.exception.controller;

import com.noteapp.exception.type.ApiException;
import com.noteapp.exception.helper.ApiExceptionJsonMessage;
import com.noteapp.exception.type.ApiExceptionWithThrowable;
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

    /**
     * when valid type with annotation of the source exception by @Valid
     * @param bindingResult
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleApiRequestArgumentNotValidException(MethodArgumentNotValidException bindingResult) {
        ApiExceptionJsonMessage apiExceptionJsonMessage = new ApiExceptionJsonMessage();
//        todo: try to testing this parts, and also understanding this object.
        apiExceptionJsonMessage.add(
                Objects.requireNonNull(
                        bindingResult.getFieldError()).getField(),
                bindingResult.getFieldError().getDefaultMessage());

        Json message = apiExceptionJsonMessage.getJsonMassage();

        ApiException apiException = new ApiException(
                HttpStatus.BAD_REQUEST,
                message,
                ZonedDateTime.now());

        return new ResponseEntity<>(
                apiException,
                HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<Object> handleApiRequestArgumentNotValidException(IllegalArgumentException bindingResult) {
        ApiExceptionJsonMessage apiExceptionJsonMessage = new ApiExceptionJsonMessage();
        apiExceptionJsonMessage.add(
                        bindingResult.getLocalizedMessage(),
                        bindingResult.getMessage());

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

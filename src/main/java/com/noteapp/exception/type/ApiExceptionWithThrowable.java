package com.noteapp.exception.type;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import springfox.documentation.spring.web.json.Json;

import java.time.ZonedDateTime;


@Getter
@EqualsAndHashCode
@AllArgsConstructor
public final class ApiExceptionWithThrowable {
    private final HttpStatus httpStatus;
    private final Json message;
    private final ZonedDateTime zonedDateTime;
    private final Throwable throwable;
}

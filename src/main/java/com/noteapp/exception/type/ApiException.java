package com.noteapp.exception.type;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import springfox.documentation.spring.web.json.Json;

import java.time.ZonedDateTime;
import java.util.Objects;

// private final, getter, public constructor, equals, hashcode
// and to string

/**
 * @author dszma
 *
 * api excepion type
 *
 * then main teregt of this class is format massage as Json type
 * with are will helpfull in frontend develot
 *
 * @see com.noteapp.exception.controller.ApiControllerAdvice
 * @see com.noteapp.user.UserService
 */

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public final class ApiException  {
    private final HttpStatus httpStatus;
    private final Json message;
    private final ZonedDateTime zonedDateTime;

}

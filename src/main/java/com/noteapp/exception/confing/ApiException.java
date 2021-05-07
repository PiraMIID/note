package com.noteapp.exception.confing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import springfox.documentation.spring.web.json.Json;

import java.time.ZonedDateTime;
import java.util.Objects;

// private final, getter, public constructor, equals, hashcode
// and to string
@Getter
@Setter
@AllArgsConstructor
public final class ApiException  {
    private final HttpStatus httpStatus;
    private final Json message;
    private final ZonedDateTime zonedDateTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApiException)) return false;
        ApiException that = (ApiException) o;
        return Objects.equals(getMessage(), that.getMessage()) && Objects.equals(getZonedDateTime(), that.getZonedDateTime()) && httpStatus == that.httpStatus;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "message=" + message +
                ", zonedDateTime=" + zonedDateTime +
                ", httpStatus=" + httpStatus +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMessage(), getZonedDateTime(), httpStatus);
    }
}

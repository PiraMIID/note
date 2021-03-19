package com.noteapp.exception.helper;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ApiExceptionJsonMessageTest {

    ApiExceptionJsonMessage underTest;

    @BeforeEach
    void setUp() {
        underTest = new ApiExceptionJsonMessage();
    }

    @Test
    public void testConstructor() {
        assertEquals("", (new ApiExceptionJsonMessage()).massages);
    }


    @Test
    void itShouldDoNotThrowWhenStringIsOk() {
        // Given
        // When
        // Then

    }

    @ParameterizedTest
    @CsvSource({
        "asfgd}sadfas",
        "asd{asgfsdrg{",
        "asf:asfwerf}",
        "asd:",
        "asdfasdgdsf\"asd"
    })
    void itShouldThrowWhenMessageInsertValidParts(String s) {
        // Given
//        the valid parts i have mean {,},",:
        // When
        // Then
        assertThrows(RuntimeException.class, () -> underTest.check(s));


    }
}


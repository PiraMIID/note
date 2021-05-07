package com.noteapp.exception.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ApiExceptionJsonMessageTest {
    @Test
    public void testConstructor() {
        assertEquals("", (new ApiExceptionJsonMessage()).massages);
    }
}


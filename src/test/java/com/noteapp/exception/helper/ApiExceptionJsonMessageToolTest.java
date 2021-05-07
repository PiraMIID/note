package com.noteapp.exception.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ApiExceptionJsonMessageToolTest {
    @Test
    public void testConstructor() {
        assertEquals("", (new ApiExceptionJsonMessageTool()).massages);
    }
}


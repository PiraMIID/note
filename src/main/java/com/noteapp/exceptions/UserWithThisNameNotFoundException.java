package com.noteapp.exceptions;

import javassist.NotFoundException;

import java.util.function.Supplier;

public class UserWithThisNameNotFoundException extends RuntimeException{
    public UserWithThisNameNotFoundException(String msg) {
        super(msg);
    }
}

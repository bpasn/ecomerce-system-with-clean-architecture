package com.app.infrastructure.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String clazz,String id) {
        super(String.format("%s not found with ID: %s", clazz.replace("Entity",""), id));
    }
}



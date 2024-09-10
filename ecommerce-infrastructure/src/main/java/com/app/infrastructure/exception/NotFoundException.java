package com.app.infrastructure.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String field,String id) {
        super(String.format("%s not found with ID: %s", field.replace("Entity",""), id));
    }
}



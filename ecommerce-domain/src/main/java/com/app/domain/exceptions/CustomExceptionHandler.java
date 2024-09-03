package com.app.domain.exceptions;

public class CustomExceptionHandler extends RuntimeException {
    EnumCode status;


    public CustomExceptionHandler(String message, EnumCode status) {
        super(message);
        System.out.println("ERROR EXCEPTION CUSTOM");
        setStatus(status);
    }

    public EnumCode getStatus() {
        return status;
    }

    public void setStatus(EnumCode status) {
        this.status = status;
    }
}
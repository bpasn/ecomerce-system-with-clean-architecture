package com.app.ecommerce.api.handler;

public class ExceptionHandler extends RuntimeException {
    ExceptionHandler(String message){
        super("EXCEPTION : " + message);
    }
}

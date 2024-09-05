package com.app.infrastructure.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException {

    HttpStatus status;

    public BaseException(String message) {
        super(message);
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public BaseException(String message,HttpStatus status){
        super(message);
        setStatus(status);
    }
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}

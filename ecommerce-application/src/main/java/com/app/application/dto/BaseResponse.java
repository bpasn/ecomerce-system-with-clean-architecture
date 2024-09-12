package com.app.application.dto;

import org.springframework.http.HttpStatus;

public class BaseResponse {
    private final HttpStatus status;

    public BaseResponse(){
        this(HttpStatus.OK);
    }

    public BaseResponse(HttpStatus status){
        this.status = status;
    }

    public HttpStatus getStatus(){
        return status;
    }

}

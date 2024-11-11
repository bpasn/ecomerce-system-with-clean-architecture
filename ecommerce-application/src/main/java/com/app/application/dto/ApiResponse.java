package com.app.application.dto;

import org.springframework.http.HttpStatus;


public class ApiResponse<D> extends BaseResponse {

    private final D payload;

    public ApiResponse(D payload) {
       this(payload,HttpStatus.OK);
    }

    public ApiResponse(D payload,HttpStatus status){
        super(status);
        this.payload = payload;
    }
    public D getPayload() {
        return payload;
    }


}

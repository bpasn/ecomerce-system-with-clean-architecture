package com.app.application;

import org.springframework.http.HttpStatus;


public class ApiResponse<D> {
    private D payload;
    private HttpStatus status;

    public ApiResponse() {
        setStatus(HttpStatus.OK);
    }
    

    public ApiResponse(D payload) {
        this.payload = payload;
    }


    public D getPayload() {
        return payload;
    }

    public void setPayload(D payload) {
        this.payload = payload;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}

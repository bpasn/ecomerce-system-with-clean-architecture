package com.app.application;

import org.springframework.http.HttpStatus;


public class ApiResponse<D> {
    private D payload;
    private HttpStatus status;

    public ApiResponse() {
    }
    

    public ApiResponse(D payload) {
        setStatus(HttpStatus.OK);
        setPayload(payload);
    }
    public ApiResponse(D payload,HttpStatus status) {
        setPayload(payload);
        setStatus(status);
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


    @Override
    public String toString() {
        return "ApiResponse [payload=" + payload + ", status=" + status + "]";
    }


    
}

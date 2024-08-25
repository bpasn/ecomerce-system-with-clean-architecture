package com.app.ecommerce.api.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.app.domain.exceptions.CustomExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class AdviceHandler {

    @ExceptionHandler(CustomExceptionHandler.class)
    public ResponseEntity<IAdviceHandler> handlerRuntimeException(CustomExceptionHandler e) {
        System.out.println("HANDLER ADVICE : "+e.getMessage());
        IAdviceHandler adviceHandler = new IAdviceHandler();
        adviceHandler.setMessage(e.getMessage());
        adviceHandler.setCode(e.getStatus().getCode());
        return new ResponseEntity<>(adviceHandler, mappedStatus(e.getStatus().getCode()));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<IAdviceHandler> handleMissingParams(MissingServletRequestParameterException ex, HttpServletRequest request) {
        IAdviceHandler adviceHandler = new IAdviceHandler();
        adviceHandler.setMessage(ex.getMessage());
        adviceHandler.setCode(400);
        return new ResponseEntity<>(adviceHandler, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<IAdviceHandler> handleTypeMismatch(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        IAdviceHandler adviceHandler = new IAdviceHandler();
        adviceHandler.setMessage(ex.getMessage());
        adviceHandler.setCode(400);
        return new ResponseEntity<>(adviceHandler, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<IAdviceHandler> MessageNotReadable(HttpMessageNotReadableException ex, HttpServletRequest request) {
        IAdviceHandler adviceHandler = new IAdviceHandler();
        adviceHandler.setMessage(ex.getMessage());
        adviceHandler.setCode(400);
        return new ResponseEntity<>(adviceHandler, HttpStatus.BAD_REQUEST);
    }

    HttpStatus mappedStatus(int code){
        switch (code) {
            case 200:
                return HttpStatus.OK;
            case 201:
                return HttpStatus.CREATED;
            case 400:
                return HttpStatus.BAD_REQUEST;
            case 401:
                return HttpStatus.UNAUTHORIZED;
            case 403:
                return HttpStatus.FORBIDDEN;
            case 404:
                return HttpStatus.NOT_FOUND;
            case 409:
                return HttpStatus.CONFLICT;
            case 500:
                return HttpStatus.INTERNAL_SERVER_ERROR;
            default:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
    public class IAdviceHandler {
        String message;
        int code;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

    }
}

package com.app.ecommerce.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<IAdviceHandler> handlerRuntimeException(RuntimeException e) {

        IAdviceHandler adviceHandler = new IAdviceHandler();
        adviceHandler.setMessage(e.getMessage());
        adviceHandler.setCode(400);
        return new ResponseEntity<>(adviceHandler, HttpStatus.CONFLICT);
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

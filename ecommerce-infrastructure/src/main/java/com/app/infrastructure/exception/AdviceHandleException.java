package com.app.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.app.domain.exceptions.DomainException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AdviceHandleException {
    @ExceptionHandler(DomainException.class)
    public ResponseEntity<IAdviceHandler> handlerRuntimeException(DomainException e) {
        IAdviceHandler adviceHandler = new IAdviceHandler();
        adviceHandler.setMessage(e.getMessage());
        adviceHandler.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(adviceHandler, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<IAdviceHandler> handleMissingParams(MissingServletRequestParameterException ex,
            HttpServletRequest request) {
        IAdviceHandler adviceHandler = new IAdviceHandler();
        adviceHandler.setMessage("Missing required parameter: " + ex.getParameterName() + "");
        adviceHandler.setStatus(400);
        return new ResponseEntity<>(adviceHandler, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<IAdviceHandler> handleTypeMismatch(MethodArgumentTypeMismatchException ex,
            HttpServletRequest request) {
        IAdviceHandler adviceHandler = new IAdviceHandler();
        adviceHandler.setMessage(
                "Parameter '" + ex.getName() + "' should be of type " + ex.getRequiredType().getName() + "");
        adviceHandler.setStatus(400);
        return new ResponseEntity<>(adviceHandler, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<IAdviceHandler> MessageNotReadable(HttpMessageNotReadableException ex,
            HttpServletRequest request) {
        IAdviceHandler adviceHandler = new IAdviceHandler();
        adviceHandler.setMessage(ex.getMessage());
        adviceHandler.setStatus(400);
        return new ResponseEntity<>(adviceHandler, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<IAdviceHandler> notFoundEntity(NotFoundException ex) {
        IAdviceHandler adviceHandler = new IAdviceHandler();
        adviceHandler.setMessage(ex.getMessage());
        adviceHandler.setStatus(400);
        return new ResponseEntity<>(adviceHandler, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<IAdviceHandler> baseException(BaseException ex) {
        IAdviceHandler adviceHandler = new IAdviceHandler();
        adviceHandler.setMessage(ex.getMessage());
        adviceHandler.setStatus(ex.status.value());
        return new ResponseEntity<>(adviceHandler, ex.status);
    }



    public class IAdviceHandler {
        String message;
        int status;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }
}

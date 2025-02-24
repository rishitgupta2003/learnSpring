package com.rishit.spring_boot.util.response_handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleApiException(ApiException ex){
        ExceptionModel exceptionModel = new ExceptionModel(
                ex.getMessage(), ex.getStatus(), ZonedDateTime.now()
        );

        return new ResponseEntity<>(exceptionModel, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex){
        ExceptionModel exceptionModel = new ExceptionModel(
                ex.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now()
        );

        return new ResponseEntity<>(exceptionModel, HttpStatus.BAD_REQUEST);
    }
}

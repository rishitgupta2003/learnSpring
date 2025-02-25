package com.rishit.spring_boot.util.response_handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiException> handleApiException(ApiException ex){
        logger.error(ex.getMessage());
        return new ResponseEntity<>(ex, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex){
        ExceptionModel exceptionModel = new ExceptionModel(
                ex.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now()
        );
        logger.error(ex.getMessage());
        return new ResponseEntity<>(exceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(err -> {
            String fieldName = ((FieldError) err).getField();
            String errorMessage = err.getDefaultMessage();
            errorMap.put(fieldName, errorMessage);
        });
        for(Map.Entry<String, String> it : errorMap.entrySet()){
            logger.error(it.getValue());
        }
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
}

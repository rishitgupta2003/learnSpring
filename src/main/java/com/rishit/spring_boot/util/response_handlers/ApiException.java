package com.rishit.spring_boot.util.response_handlers;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

record ExceptionModel(String message, HttpStatus status, ZonedDateTime timeStamp) {}

@Getter
public class ApiException extends RuntimeException{
    private final HttpStatus status;

    public ApiException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
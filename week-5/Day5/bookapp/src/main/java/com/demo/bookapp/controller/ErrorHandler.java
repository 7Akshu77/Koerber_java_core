package com.demo.bookapp.controller;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handle400(MethodArgumentNotValidException ex){
        String errorMsg = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));
        ErrorDetails error= ErrorDetails.builder().errorCode(400)
                .timestamp(java.time.LocalDateTime.now())
                .errorMessage(errorMsg)
                .toContact("Admin@koerber.com").build();
        return ResponseEntity.status(400).body(error);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handle500(Exception ex) {
        ErrorDetails error = ErrorDetails.builder().errorCode(201)
                .timestamp(java.time.LocalDateTime.now())
                .errorMessage("Try again later")
                .toContact("Admin@koerber.com").build();
        return ResponseEntity.status(201).body(error);
    }
}

package com.demo.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(AccountNotFound.class)
    public ResponseEntity<ErrorDetails> handleAccountNotFound(AccountNotFound ex){
        ErrorDetails error= ErrorDetails.builder().errorCode(404)
                .timestamp(java.time.LocalDateTime.now())
                .errorMessage(ex.getMessage())
                .toContact("Admin@koerber.com").build();
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleException(MethodArgumentNotValidException ex){
        String errorMsg = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));
        ErrorDetails error= ErrorDetails.builder().errorCode(400)
                .timestamp(java.time.LocalDateTime.now())
                .errorMessage(errorMsg)
                .toContact("Admin@koerber.com").build();
        return ResponseEntity.status(400).body(error);
    }

}

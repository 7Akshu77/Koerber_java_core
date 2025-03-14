package com.productapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorInfo {
    private String message;
    private String statusCode;
    private String toContact;
    private LocalDateTime localDateTime;

    public ErrorInfo( String toContact, String statusCode, String message) {
        this.toContact = toContact;
        this.statusCode = statusCode;
        this.message = message;
    }
}

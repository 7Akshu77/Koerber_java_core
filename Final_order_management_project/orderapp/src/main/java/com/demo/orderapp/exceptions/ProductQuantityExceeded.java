package com.demo.orderapp.exceptions;

public class ProductQuantityExceeded extends RuntimeException {
    public ProductQuantityExceeded(String message) {
        super(message);
    }
}

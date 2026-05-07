package com.simplify.restservices.exceptions;

public class OrderException extends RuntimeException{
    public OrderException(String message) {
        super(message);
    }
}

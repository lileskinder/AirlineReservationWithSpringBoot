package com.example.airline_reservation.ExceptionHandling;

public class MyCustomException extends RuntimeException{
    public MyCustomException() {
        super();
    }
    public MyCustomException(String message) {
        super(message);
    }
}


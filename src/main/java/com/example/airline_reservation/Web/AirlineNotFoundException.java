package com.example.airline_reservation.Web;

public class AirlineNotFoundException extends RuntimeException{
    public AirlineNotFoundException(String message) {
        super(message);
    }

    public AirlineNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AirlineNotFoundException(Throwable cause) {
        super(cause);
    }
}

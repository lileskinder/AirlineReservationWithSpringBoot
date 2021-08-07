package com.example.airline_reservation.Model;

import lombok.Data;

@Data
public class Ticket {
    private int id;
    // must be 20 digit
    private int number;
    private String reservationCode;
    private Passenger passenger;
    private Flight flight;
}

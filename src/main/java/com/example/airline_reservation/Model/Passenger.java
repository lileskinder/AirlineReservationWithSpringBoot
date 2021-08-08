package com.example.airline_reservation.Model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Passenger extends User {
    private LocalDate dob;
}

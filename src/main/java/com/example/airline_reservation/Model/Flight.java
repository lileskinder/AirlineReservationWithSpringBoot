package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue
    private int id;
    private int number;
    private int capacity;

    @ManyToOne @JoinColumn
    private Airline airline;

    @ManyToOne @JoinColumn
    private Airport departureAirport;

    @ManyToOne @JoinColumn
    private Airport arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}

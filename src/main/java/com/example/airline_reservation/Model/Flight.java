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


    public Flight() {
    }

    public Flight(int number, int capacity, Airline airline, Airport departureAirport, Airport arrivalAirport, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.number = number;
        this.capacity = capacity;
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
}

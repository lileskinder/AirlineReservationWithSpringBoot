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

    @Column(unique = true, nullable = false, updatable = false)
    private int number;

    @Column(nullable = false)
    private int capacity;

    @ManyToOne @JoinColumn
    private Airline airline;

    @ManyToOne @JoinColumn
    private Airport departureAirport;

    @ManyToOne @JoinColumn
    private Airport arrivalAirport;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @Column(nullable = false)
    private String flightStatus;


    public Flight() {
    }

    public Flight(int number, int capacity, Airline airline, Airport departureAirport, Airport arrivalAirport, LocalDateTime departureTime, LocalDateTime arrivalTime, String flightStatus) {
        this.number = number;
        this.capacity = capacity;
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightStatus = flightStatus;
    }


}

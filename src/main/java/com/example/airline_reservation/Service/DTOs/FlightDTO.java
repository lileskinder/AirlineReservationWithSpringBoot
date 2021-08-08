package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Model.Airport;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FlightDTO {
    private int number;
    private int capacity;
    private Airline airline;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    public FlightDTO() {
    }

    public FlightDTO(int number, int capacity, Airline airline, Airport departureAirport, Airport arrivalAirport, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.number = number;
        this.capacity = capacity;
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

}


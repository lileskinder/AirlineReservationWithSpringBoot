package com.example.airline_reservation.Service.DTOs;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightDTO {
    private int number;
    private int capacity;
    private int airlineId;
    private int departureAirportId;
    private int arrivalAirportId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String flightStatus;

    public FlightDTO() {
    }

    public FlightDTO(int number, int capacity, int airlineId, int departureAirportId, int arrivalAirportId, LocalDateTime departureTime, LocalDateTime arrivalTime, String flightStatus) {
        this.number = number;
        this.capacity = capacity;
        this.airlineId = airlineId;
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightStatus = flightStatus;
    }
}


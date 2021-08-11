package com.example.airline_reservation.Service.DTOs;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
public class PassengerTicketDTO {
    private int number;

    @EqualsAndHashCode.Exclude
    private String passengerName;

    @EqualsAndHashCode.Exclude
    private int flightNumber;

    private String airlineName;
    private String departureAirportName;
    private String arrivalAirportName;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String flightStatus;
}

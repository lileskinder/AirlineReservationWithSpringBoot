package com.example.airline_reservation.Service.DTOs;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class TicketDTO {
    private int number;

    @EqualsAndHashCode.Exclude
    private int passengerId;

    @EqualsAndHashCode.Exclude
    private int flightId;
}

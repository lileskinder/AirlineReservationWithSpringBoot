package com.example.airline_reservation.Service.DTOs;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;

@Data
public class TicketDTO {
    private BigInteger number;

    @EqualsAndHashCode.Exclude
    private int passengerId;

    @EqualsAndHashCode.Exclude
    private int flightId;

    @EqualsAndHashCode.Exclude
    private String reservationCode;

    public TicketDTO() {
    }

    public TicketDTO(BigInteger number, int passengerId, int flightId, String reservationCode) {
        this.number = number;
        this.passengerId = passengerId;
        this.flightId = flightId;
        this.reservationCode = reservationCode;
    }
}

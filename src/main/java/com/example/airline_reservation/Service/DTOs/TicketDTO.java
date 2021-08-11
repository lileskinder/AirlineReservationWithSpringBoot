package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Flight;
import com.example.airline_reservation.Model.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class TicketDTO {
    private int number;

    @EqualsAndHashCode.Exclude
    private int passengerId;

    @EqualsAndHashCode.Exclude
    private int flightId;
}

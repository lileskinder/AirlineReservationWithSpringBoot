package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.ReservationStatus;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReservationDTO {
    private int id;
    private String code;
    private int customerId;
    private List<TicketDTO> tickets = new ArrayList<>();
    private ReservationStatus status;
}

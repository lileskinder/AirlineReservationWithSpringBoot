package com.example.airline_reservation.Service;

import com.example.airline_reservation.Model.Flight;
import com.example.airline_reservation.Service.DTOs.TicketDTO;

import java.util.List;

public interface TicketService {
    public List<TicketDTO> getFlightsFromTicket(int id);
}

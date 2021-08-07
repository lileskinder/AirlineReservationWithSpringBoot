package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {
}

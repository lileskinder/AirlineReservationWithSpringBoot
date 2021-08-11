package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository @Transactional
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
}

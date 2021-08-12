package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository @Transactional
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

    @Query("SELECT t from Ticket t WHERE t.number = :number")
    Optional<Ticket> getTicketByNumber(Integer number);
}

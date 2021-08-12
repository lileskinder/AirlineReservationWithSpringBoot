package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository @Transactional
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
    //number of tickets for certain flights

    @Query("SELECT distinct t from Ticket t where t.flight.id = :flightId")
    List<Ticket> getListOfTickets(int flightId);

}

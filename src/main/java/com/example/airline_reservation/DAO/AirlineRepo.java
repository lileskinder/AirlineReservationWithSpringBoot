package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Service.DTOs.AirlineDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository @Transactional
public interface AirlineRepo extends JpaRepository<Airline, Integer> {
    @Query("SELECT a from Airline a WHERE a.code = ?1")
    Optional<Airline> findByCode(String code);

    @Query("SELECT f.airline from Flight f where f.departureAirport.code = :airportCode")
    List<Airline> findFlightsFromAirport(String airportCode);

}

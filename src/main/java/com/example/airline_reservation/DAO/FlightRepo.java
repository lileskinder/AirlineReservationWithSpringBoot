package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {
    @Query("SELECT f from Flight f WHERE f.number = ?1")
    Optional<Flight> findByFlightNumber(Integer flightNumber);

    @Query("SELECT f from Flight f WHERE f.number = ?1")
    boolean existByFlightNumber(Integer flightNumber);

    @Query("SELECT f from Flight f WHERE f.departureTime >= ?1 and f.departureTime < ?2")
    List<Flight> findByDate(LocalDateTime departureDate, LocalDateTime departureDatePlus);

    @Query("SELECT f from Flight f WHERE f.departureAirport.id = ?1")
    List<Flight> flightsFromAirport(Integer airportId);
}

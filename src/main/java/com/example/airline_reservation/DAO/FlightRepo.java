package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepo extends JpaRepository<Flight, Integer> {
}

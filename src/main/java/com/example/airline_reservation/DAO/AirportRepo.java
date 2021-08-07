package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepo extends JpaRepository<Airport, Integer> {
}

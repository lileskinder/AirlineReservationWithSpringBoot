package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepo extends JpaRepository<Airline, Integer> {
}

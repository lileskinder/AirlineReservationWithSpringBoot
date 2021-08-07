package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepo extends JpaRepository<Airline, Integer> {
}

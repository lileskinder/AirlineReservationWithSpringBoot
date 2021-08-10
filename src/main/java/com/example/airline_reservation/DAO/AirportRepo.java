package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AirportRepo extends JpaRepository<Airport, Integer> {
}

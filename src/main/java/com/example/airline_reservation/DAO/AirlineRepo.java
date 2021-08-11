package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AirlineRepo extends JpaRepository<Airline, Integer> {
    @Query("SELECT a from Airline a WHERE a.code = ?1")
    Optional<Airline> findByCode(String code);
}

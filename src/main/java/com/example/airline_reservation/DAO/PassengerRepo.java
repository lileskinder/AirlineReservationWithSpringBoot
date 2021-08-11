package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Integer> {
}

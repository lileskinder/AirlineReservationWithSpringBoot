package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation, Integer> {
}

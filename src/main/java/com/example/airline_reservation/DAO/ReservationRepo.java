package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

    @Query("select r from Reservation r where r.code = :code")
    public Optional<Reservation> findByCode(@Param("code") String code);
}

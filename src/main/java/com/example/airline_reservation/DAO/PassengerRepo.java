package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PassengerRepo extends JpaRepository<Passenger, Integer> {

//    @Query("select p from Passenger p join fetch Person pe on p.id = pe.id where p.id = :id")
//    public Passenger getPassengerBy(@Param("id") int id);
}

package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository @Transactional
public interface ReservationRepo extends JpaRepository<Reservation, Integer> {

    @Query("select r from Reservation r where r.code = :code")
    Optional<Reservation> findByCode(@Param("code") String code);

//    @Query("select distinct r from Reservation r where r.code = :code and r.customer.userName =: username")
//    List<Reservation> findOwnReservation(@Param("code") String code, @Param("username") String username);

    @Query("select distinct r from Reservation r where r.customer.userName = :username")
    List<Reservation> findOwnReservation(@Param("username") String username);
}

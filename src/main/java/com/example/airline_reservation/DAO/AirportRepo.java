package com.example.airline_reservation.DAO;
import com.example.airline_reservation.Model.Airport;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface AirportRepo extends JpaRepository<Airport, Integer> {
//    @Query("SELECT A from Airport a WHERE a.code = ?1")
//    Optional<Airport> findByAirportNumber(Integer AirportCode);
    Airport findByCode(String code);
}

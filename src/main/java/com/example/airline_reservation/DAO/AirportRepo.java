package com.example.airline_reservation.DAO;
import com.example.airline_reservation.Model.Airport;
import com.example.airline_reservation.Service.DTOs.AirlineDTO;
import com.example.airline_reservation.Service.DTOs.AirportDTO;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository @Transactional
public interface AirportRepo extends JpaRepository<Airport, Integer> {
    @Query("SELECT a from Airport a WHERE a.code = :code")
    Airport findByCode(String code);
}

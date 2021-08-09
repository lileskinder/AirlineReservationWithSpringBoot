package com.example.airline_reservation.Service;


import com.example.airline_reservation.Model.Airport;
import com.example.airline_reservation.Service.DTOs.AirportDTO;
import org.hibernate.sql.Update;

import java.util.List;

public interface AirportService {

    List<AirportDTO> getAllAirport();
    AirportDTO save(AirportDTO airportDTO);
    AirportDTO Update(AirportDTO airportDTO);
    Airport getAirportById(int airportId);
    void deleteAirport(int airportId);
}

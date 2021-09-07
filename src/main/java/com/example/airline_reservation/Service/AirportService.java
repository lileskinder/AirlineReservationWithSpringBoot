package com.example.airline_reservation.Service;


import com.example.airline_reservation.Model.Airport;
import com.example.airline_reservation.Service.DTOs.AirportDTO;

import java.util.List;

public interface AirportService {

    List<AirportDTO> getAllAirport();
    AirportDTO save(AirportDTO airportDTO);
    AirportDTO Update(AirportDTO airportDTO);
    AirportDTO Update(int airportId, AirportDTO airportDTO);
    Airport getAirportByCode(String airportCode);
    void deleteAirport(int airportId);
}

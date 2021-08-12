package com.example.airline_reservation.Service;

import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Service.DTOs.AirlineDTO;
import com.example.airline_reservation.Service.DTOs.AirportDTO;

import java.util.List;
import java.util.Optional;

public interface AirlineService {
    Airline findById(Integer id);
    Airline findByCode(String code);
    AirlineDTO Update(int id, AirlineDTO airlinDTO);
    void delete(int id);

    List<AirlineDTO> findAll(Optional<Integer> page);
    AirlineDTO save(AirlineDTO airlineDTO);
    List<AirlineDTO> findFlightsFromAirport(String airportCode);

}

package com.example.airline_reservation.Service;

import com.example.airline_reservation.Service.DTOs.AirlineDTO;

import java.util.List;

public interface AirlineService {
    List<AirlineDTO> findAll();
    AirlineDTO findById(Integer id);
    AirlineDTO save(AirlineDTO airlineDTO);
}

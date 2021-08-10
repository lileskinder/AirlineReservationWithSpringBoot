package com.example.airline_reservation.Service;

import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Web.DTOs.AirlineDTO;

import java.util.List;
import java.util.Optional;

public interface AirlineService {
    public Airline findById(Integer id);
    public Airline findByCode(String code);
    public AirlineDTO Update(int id, AirlineDTO airlinDTO);
    public void delete(int id);

    public List<AirlineDTO> findAll(Optional<Integer> page);
    public AirlineDTO save(AirlineDTO airlineDTO);
}

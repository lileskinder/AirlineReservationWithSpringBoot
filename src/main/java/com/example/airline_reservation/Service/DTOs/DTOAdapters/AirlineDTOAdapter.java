package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Service.DTOs.AirlineDTO;


public class AirlineDTOAdapter {
    public static Airline getAirline(AirlineDTO airlineDTO) {
        Airline airline = new Airline();

        airline.setCode(airlineDTO.getCode());
        airline.setName(airlineDTO.getName());
        airline.setHistory(airlineDTO.getHistory());

        return airline;
    }

    public static AirlineDTO getAirlineDTO(Airline airline) {
        AirlineDTO airlineDTO = new AirlineDTO();

        airlineDTO.setCode(airline.getCode());
        airlineDTO.setName(airline.getName());
        airlineDTO.setHistory(airline.getHistory());

        return airlineDTO;
    }
}

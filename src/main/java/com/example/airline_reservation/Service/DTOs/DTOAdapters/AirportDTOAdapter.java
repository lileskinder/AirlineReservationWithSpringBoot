package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.Model.Airport;
import com.example.airline_reservation.Service.DTOs.AirportDTO;

public class AirportDTOAdapter {
    public static Airport getAirport(AirportDTO airportDTO) {
        Airport airport = new Airport();

        airport.setCode(airportDTO.getCode());
        airport.setName(airportDTO.getName());
        airport.setAddress(airportDTO.getAddress());

        return airport;

    }

    public static AirportDTO getAirportDTO(Airport airport) {
        AirportDTO airportDTO = new AirportDTO();

        airportDTO.setCode(airport.getCode());
        airportDTO.setName(airport.getName());
        airport.setAddress(airport.getAddress());

        return airportDTO;
    }
}

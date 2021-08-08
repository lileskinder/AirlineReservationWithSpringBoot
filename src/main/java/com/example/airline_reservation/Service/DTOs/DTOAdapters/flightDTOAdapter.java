package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.Model.Flight;
import com.example.airline_reservation.Service.DTOs.FlightDTO;

public class flightDTOAdapter {
    public static Flight getFlight(FlightDTO flightDTO) {
        Flight flight = new Flight();

        flight.setNumber(flightDTO.getNumber());
        flight.setCapacity(flightDTO.getCapacity());
        flight.setAirline(flightDTO.getAirline());
        flight.setDepartureAirport(flightDTO.getDepartureAirport());
        flight.setArrivalAirport(flightDTO.getArrivalAirport());
        flight.setDepartureTime(flightDTO.getDepartureTime());
        flight.setArrivalTime(flightDTO.getArrivalTime());

        return flight;
    }

    public static FlightDTO getFlightDTO(Flight flight) {
        FlightDTO flightDTO = new FlightDTO();

        flightDTO.setNumber(flight.getNumber());
        flightDTO.setCapacity(flight.getCapacity());
        flightDTO.setAirline(flight.getAirline());
        flightDTO.setDepartureAirport(flight.getDepartureAirport());
        flightDTO.setArrivalAirport(flight.getArrivalAirport());
        flightDTO.setDepartureTime(flight.getDepartureTime());
        flightDTO.setArrivalTime(flight.getArrivalTime());

        return flightDTO;
    }
}

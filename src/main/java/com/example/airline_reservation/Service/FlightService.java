package com.example.airline_reservation.Service;

import com.example.airline_reservation.Service.DTOs.FlightDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    List<FlightDTO> findAll();

    FlightDTO addFlight(FlightDTO flightDTO);

    FlightDTO findByFlightNumber(Integer flightNumber);

    FlightDTO updateFlight(Integer flightNumber,
                           int capacity,
                           int airlineId,
                           int departureAirportId,
                           int arrivalAirportId,
                           LocalDateTime departureTime,
                           LocalDateTime arrivalTime,
                           String flightStatus);

    FlightDTO cancelFlight(Integer flightNumber, String flightStatus);

    List<FlightDTO> flightsInSpecificDate(LocalDate departureDate);

    List<FlightDTO> findFlightsFromAirport(Integer airportId);
}

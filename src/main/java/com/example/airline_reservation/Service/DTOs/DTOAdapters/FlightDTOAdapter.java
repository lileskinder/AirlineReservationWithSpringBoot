package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.DAO.AirlineRepo;
import com.example.airline_reservation.DAO.AirportRepo;
import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Model.Airport;
import com.example.airline_reservation.Model.Flight;
import com.example.airline_reservation.Service.DTOs.FlightDTO;

public class FlightDTOAdapter {


    public static Flight getFlight(FlightDTO flightDTO, AirportRepo airportRepo, AirlineRepo airlineRepo) {
        Flight flight = new Flight();

        flight.setNumber(flightDTO.getNumber());
        flight.setCapacity(flightDTO.getCapacity());

        Airline airline = airlineRepo.getById(flightDTO.getAirlineId());
        flight.setAirline(airline);


        Airport departureAirport = airportRepo.getById(flightDTO.getDepartureAirportId());
        flight.setDepartureAirport(departureAirport);

        Airport arrivalAirport = airportRepo.getById(flightDTO.getArrivalAirportId());
        flight.setArrivalAirport(arrivalAirport);

        flight.setDepartureTime(flightDTO.getDepartureTime());
        flight.setArrivalTime(flightDTO.getArrivalTime());

        flight.setFlightStatus(flightDTO.getFlightStatus());
        return flight;
    }

    public static FlightDTO getFlightDTO(Flight flight) {
        FlightDTO flightDTO = new FlightDTO();

        flightDTO.setNumber(flight.getNumber());
        flightDTO.setCapacity(flight.getCapacity());
        flightDTO.setAirlineId(flight.getAirline().getId());
        flightDTO.setDepartureAirportId(flight.getDepartureAirport().getId());
        flightDTO.setArrivalAirportId(flight.getArrivalAirport().getId());
        flightDTO.setDepartureTime(flight.getDepartureTime());
        flightDTO.setArrivalTime(flight.getArrivalTime());
        flightDTO.setFlightStatus(flight.getFlightStatus());


        return flightDTO;
    }

}

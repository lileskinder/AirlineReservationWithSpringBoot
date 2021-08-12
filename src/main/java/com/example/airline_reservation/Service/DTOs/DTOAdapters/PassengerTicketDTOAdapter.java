package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.DAO.FlightRepo;
import com.example.airline_reservation.Model.Flight;
import com.example.airline_reservation.Model.Passenger;
import com.example.airline_reservation.Model.Reservation;
import com.example.airline_reservation.Model.Ticket;
import com.example.airline_reservation.Service.DTOs.PassengerDTO;
import com.example.airline_reservation.Service.DTOs.PassengerTicketDTO;
import com.example.airline_reservation.Service.DTOs.ReservationDTO;
import com.example.airline_reservation.Service.DTOs.TicketDTO;
import com.example.airline_reservation.Service.FlightService;
import com.example.airline_reservation.Service.PassengerService;
import com.example.airline_reservation.Service.ReservationService;

public class PassengerTicketDTOAdapter {

    public static PassengerTicketDTO getPassengerTicketDTO(
            Ticket ticket, ReservationService reservationService
    ) {

        PassengerTicketDTO passengerTicketDTO = new PassengerTicketDTO();

        passengerTicketDTO.setNumber(ticket.getNumber());
        passengerTicketDTO.setPassengerName(
                ticket.getPassenger().getFirstName() + " " + ticket.getPassenger().getLastName()
        );

        passengerTicketDTO.setFlightNumber(ticket.getFlight().getNumber());

        passengerTicketDTO.setAirlineName(ticket.getFlight().getAirline().getName());

        passengerTicketDTO.setDepartureAirportName(ticket.getFlight().getDepartureAirport().getName());
        passengerTicketDTO.setArrivalAirportName(ticket.getFlight().getArrivalAirport().getName());

        passengerTicketDTO.setDepartureTime(ticket.getFlight().getDepartureTime());
        passengerTicketDTO.setArrivalTime(ticket.getFlight().getArrivalTime());
        passengerTicketDTO.setFlightStatus(ticket.getFlight().getFlightStatus());
        passengerTicketDTO.setReservationCode(ticket.getReservationCode());

        ReservationDTO reservationDTO = reservationService.getReservationByCode(
                passengerTicketDTO.getReservationCode()
        );

        passengerTicketDTO.setReservationStatus(reservationDTO.getStatus());

        return passengerTicketDTO;
    }
}

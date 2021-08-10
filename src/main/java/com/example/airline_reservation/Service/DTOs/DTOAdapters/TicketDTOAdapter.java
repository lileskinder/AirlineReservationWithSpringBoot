package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.DAO.FlightRepo;
import com.example.airline_reservation.Model.Flight;
import com.example.airline_reservation.Model.Passenger;
import com.example.airline_reservation.Model.Ticket;
import com.example.airline_reservation.Service.DTOs.TicketDTO;
import com.example.airline_reservation.Service.PassengerService;

public class TicketDTOAdapter {


    public static Ticket getTicket(TicketDTO ticketDTO,
                                   PassengerService passengerService, FlightRepo flightRepo) {
        TicketDTOAdapter ticketDTOAdapter = new TicketDTOAdapter();
        Ticket ticket = new Ticket();

        ticket.setNumber(ticketDTO.getNumber());
        ticket.setReservationCode(ticketDTO.getReservationCode());

        Passenger passenger = PassengerDTOAdapter.getPassenger(
                passengerService.getPassengerById(ticketDTO.getPassengerId()));
        ticket.setPassenger(passenger);

        Flight flight = (Flight) flightRepo.getById(ticketDTO.getFlightId());

        ticket.setFlight(flight);

        return ticket;
    }

    public static TicketDTO getTicketDTO(Ticket ticket) {

        TicketDTO ticketDTO = new TicketDTO();

        ticketDTO.setNumber(ticket.getNumber());
        ticketDTO.setReservationCode(ticket.getReservationCode());
        ticketDTO.setPassengerId(ticket.getPassenger().getId());
        ticketDTO.setFlightId(ticket.getFlight().getId());

        return ticketDTO;
    }
}

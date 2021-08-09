package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.DAO.FlightRepo;
import com.example.airline_reservation.DAO.PersonRepo;
import com.example.airline_reservation.Model.Flight;
import com.example.airline_reservation.Model.Passenger;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Model.Ticket;
import com.example.airline_reservation.Service.DTOs.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketDTOAdapter {


    public static Ticket getTicket(TicketDTO ticketDTO,
                                   PersonRepo personRepo, FlightRepo flightRepo) {
        TicketDTOAdapter ticketDTOAdapter = new TicketDTOAdapter();
        Ticket ticket = new Ticket();

        ticket.setNumber(ticketDTO.getNumber());
        ticket.setReservationCode(ticketDTO.getReservationCode());
        System.out.println(ticketDTO.getPassengerId());
//        System.out.println(personRepo.getById(new Integer(ticketDTO.getPassengerId())));

        Person passenger = personRepo.getById(ticketDTO.getPassengerId());
        System.out.println(passenger);
        System.out.println(passenger.getFirstName());
//        ticket.setPassenger(passenger);

        Flight flight = (Flight) flightRepo.getById(ticketDTO.getFlightId());

        ticket.setFlight(flight);

        return ticket;
    }

    public static TicketDTO getTicketDTO(Ticket ticket) {

        TicketDTO ticketDTO = new TicketDTO();return ticketDTO;

//        ticketDTO.setNumber(ticket.getNumber());
//        ticketDTO.setReservationCode(ticket.getReservationCode());
//        ticketDTO.setPassengerId(ticket.getPassenger().getId());
//        ticketDTO.setFlightId(ticket.getFlight().getId());
//
//        return ticketDTO;
    }
}

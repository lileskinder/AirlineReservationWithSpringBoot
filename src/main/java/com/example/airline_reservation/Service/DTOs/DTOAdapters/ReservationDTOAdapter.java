package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.DAO.FlightRepo;
import com.example.airline_reservation.DAO.PersonRepo;
import com.example.airline_reservation.Model.Flight;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Model.Reservation;
import com.example.airline_reservation.Model.Ticket;
import com.example.airline_reservation.Service.DTOs.ReservationDTO;
import com.example.airline_reservation.Service.DTOs.TicketDTO;
import com.example.airline_reservation.Service.Implementation.PassengerServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ReservationDTOAdapter {

    public static Reservation getReservation(ReservationDTO reservationDTO,
                                             PersonRepo personRepo,
                                             PassengerServiceImpl passengerService,
                                             FlightRepo flightRepo) {
        Reservation reservation = new Reservation();

        reservation.setId(reservationDTO.getId());
        reservation.setCode(reservationDTO.getCode());

        Person customer = personRepo.getById(reservationDTO.getCustomerId());

        reservation.setCustomer(customer);

        List<Ticket> ticketList =  new ArrayList<>();

        for(TicketDTO ticketDTO: reservationDTO.getTickets()) {
            ticketList.add(TicketDTOAdapter.getTicket(ticketDTO, passengerService, flightRepo));
        }

        reservation.setTickets(ticketList);
        reservation.setStatus(reservationDTO.getStatus());

        return reservation;
    }

    public static ReservationDTO getReservationDTO(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setId(reservation.getId());
        reservationDTO.setCode(reservation.getCode());
        reservationDTO.setCustomerId(reservation.getCustomer().getId());

        List<TicketDTO> ticketDTOList =  new ArrayList<>();

        for(Ticket ticket: reservation.getTickets()) {
            ticketDTOList.add(TicketDTOAdapter.getTicketDTO(ticket));
        }

        reservationDTO.setTickets(ticketDTOList);
        reservationDTO.setStatus(reservation.getStatus());

        return reservationDTO;
    }
}

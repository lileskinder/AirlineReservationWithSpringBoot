package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.FlightRepo;
import com.example.airline_reservation.DAO.TicketRepo;
import com.example.airline_reservation.Model.Flight;
import com.example.airline_reservation.Model.Ticket;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.FlightDTOAdapter;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.PassengerTicketDTOAdapter;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.TicketDTOAdapter;
import com.example.airline_reservation.Service.DTOs.FlightDTO;
import com.example.airline_reservation.Service.DTOs.PassengerTicketDTO;
import com.example.airline_reservation.Service.DTOs.TicketDTO;
import com.example.airline_reservation.Service.PassengerService;
import com.example.airline_reservation.Service.ReservationService;
import com.example.airline_reservation.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    TicketRepo ticketRepo;
    PassengerService passengerService;
    FlightRepo flightRepo;
    ReservationService reservationService;

    @Autowired
    public TicketServiceImpl(TicketRepo ticketRepo,
                             PassengerService passengerService,
                             FlightRepo flightRepo,
                             ReservationService reservationService
    ) {
        this.ticketRepo = ticketRepo;
        this.passengerService = passengerService;
        this.flightRepo = flightRepo;
        this.reservationService = reservationService;
    }

    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = TicketDTOAdapter.getTicket(ticketDTO, passengerService, flightRepo);

        return TicketDTOAdapter.getTicketDTO(ticketRepo.save(ticket));
    }

    public List<TicketDTO> findAllTickets() {
        List<TicketDTO> ticketDTOList = new ArrayList<>();

        for (Ticket ticket: ticketRepo.findAll()) {
            ticketDTOList.add(TicketDTOAdapter.getTicketDTO(ticket));
        }

        return ticketDTOList;
    }

    public TicketDTO getTicket(int id) {

        return TicketDTOAdapter.getTicketDTO(ticketRepo.getById(id));
    }

    public PassengerTicketDTO getPassengerTicketDetails(int number) {

        Optional<Ticket> ticketOptional = ticketRepo.getTicketByNumber(number);
        Ticket ticket = ticketOptional.get();
        PassengerTicketDTO passengerTicketDTO = PassengerTicketDTOAdapter.getPassengerTicketDTO(
                ticket, reservationService);

        if (ticketOptional.isPresent()) {
            return passengerTicketDTO;
        } else {
            throw new IllegalStateException("Ticket Number does not exist!!!");
        }
    }
}

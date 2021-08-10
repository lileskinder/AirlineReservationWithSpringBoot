package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.FlightRepo;
import com.example.airline_reservation.DAO.PassengerRepo;
import com.example.airline_reservation.DAO.TicketRepo;
import com.example.airline_reservation.Model.Ticket;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.TicketDTOAdapter;
import com.example.airline_reservation.Service.DTOs.TicketDTO;
import com.example.airline_reservation.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    PassengerServiceImpl passengerService;

    @Autowired
    FlightRepo flightRepo;

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
}

package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.FlightRepo;
import com.example.airline_reservation.DAO.PersonRepo;
import com.example.airline_reservation.DAO.TicketRepo;
import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Model.Ticket;
import com.example.airline_reservation.Service.DTOs.AirlineDTO;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.AirlineDTOAdapter;
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
    PersonRepo personRepo;

    @Autowired
    FlightRepo flightRepo;

    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = TicketDTOAdapter.getTicket(ticketDTO, personRepo, flightRepo);

        return TicketDTOAdapter.getTicketDTO(ticketRepo.save(ticket));

//        return ticketDTO;
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

package com.example.airline_reservation.Web;

import com.example.airline_reservation.Model.Ticket;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.TicketDTOAdapter;
import com.example.airline_reservation.Service.DTOs.TicketDTO;
import com.example.airline_reservation.Service.Implementation.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

//    @GetMapping("/tickets")
//    public ResponseEntity<List<TicketDTO>> getAllTickets() {
//        List<TicketDTO> tickets = ticketService.findAllTickets();
//
//        return new ResponseEntity<List<TicketDTO>>(tickets, HttpStatus.OK);
//    }
//
//    @GetMapping("/tickets/{id}")
//    public ResponseEntity<TicketDTO> getTicket(@PathVariable int id) {
//        return new ResponseEntity<TicketDTO>(ticketService.getTicket(id), HttpStatus.OK);
//    }
//
    @PostMapping("/tickets")
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
        TicketDTO ticketdto = new TicketDTO();


//        return new ResponseEntity<TicketDTO>(ticketdto, HttpStatus.OK);
        return new ResponseEntity<TicketDTO>(ticketService.createTicket(ticketDTO), HttpStatus.OK);
    }
}

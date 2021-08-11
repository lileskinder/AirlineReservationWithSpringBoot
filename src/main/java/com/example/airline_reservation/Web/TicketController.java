package com.example.airline_reservation.Web;

import com.example.airline_reservation.Model.Ticket;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.TicketDTOAdapter;
import com.example.airline_reservation.Service.DTOs.PassengerTicketDTO;
import com.example.airline_reservation.Service.DTOs.TicketDTO;
import com.example.airline_reservation.Service.Implementation.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketServiceImpl ticketService;
    @Autowired
    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTicket(@PathVariable int id) {
        return new ResponseEntity<PassengerTicketDTO>(ticketService.getPassengerTicketDetails(id), HttpStatus.OK);
    }
}

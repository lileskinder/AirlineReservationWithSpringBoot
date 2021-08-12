package com.example.airline_reservation.Web;

import com.example.airline_reservation.Service.Implementation.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketServiceImpl ticketService;
    @Autowired
    public TicketController(TicketServiceImpl ticketService) {
        this.ticketService = ticketService;
    }

    //    TODO: confirmReservation for passanger and agent only

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> getTicket(@PathVariable int id) {
        return new ResponseEntity<>(ticketService.getPassengerTicketDetails(id), HttpStatus.OK);
    }
}

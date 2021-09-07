package com.example.airline_reservation.Web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.airline_reservation.ExceptionHandling.ResourceNotFoundException;
import com.example.airline_reservation.Service.ReservationService;
import com.example.airline_reservation.Service.TicketService;
import com.example.airline_reservation.Service.DTOs.ReservationDTO;
import com.example.airline_reservation.Service.DTOs.TicketDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService reservationService;
    private TicketService ticketService;

    @Autowired
    public ReservationController(ReservationService reservationService,
                                 TicketService ticketService) {
        this.reservationService = reservationService;
        this.ticketService = ticketService;
    }

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> getReservations(@RequestParam Optional<Integer> page) {
        List<ReservationDTO> reservationDTOList = reservationService.getReservations(page);
        return new ResponseEntity<>(reservationDTOList, HttpStatus.OK);
    }

    @GetMapping("/my")
    @PreAuthorize("hasAnyRole('PASSENGER')")
    public ResponseEntity<?> getPersonReservations(@RequestParam Optional<Integer> page, Authentication authentication) {
        String name = authentication.getName();
        return new ResponseEntity<>(
                reservationService.getPersonReservations(page, name), //name
                HttpStatus.OK
        );
    }

    @GetMapping("/{code}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> getReservation(@PathVariable String code, Authentication authentication) {
        //String name = authentication.getName();
        return new ResponseEntity<>(
                reservationService.getReservationByCode(code), //name
                HttpStatus.OK
        );
    }

    @PostMapping("")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<?> postReservations(@Valid  @RequestBody ReservationDTO reservationDTO) {

        List<TicketDTO> tickets = reservationService.getReservationTicketsAvailability(reservationDTO);

        if(tickets.size() == 0) {
            throw new ResourceNotFoundException("Ticket(s) not available for this reservation!!!");
        } else {
            reservationDTO.setTickets(tickets);
        }

        return new ResponseEntity<>(
                reservationService.makeReservation(reservationDTO),
                HttpStatus.OK
        );
    }

    @PutMapping("/{code}")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<?> updateReservation(
            @PathVariable String code,
            @Valid @RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<>(
                reservationService.updateReservation(code, reservationDTO),
                HttpStatus.OK
        );
    }

    @PutMapping("/confirm/{code}")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<?> confirmReservation(
            @PathVariable String code,
            @Valid @RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<>(
                reservationService.confirmReservation(code, reservationDTO),
                HttpStatus.OK
        );
    }

    @PutMapping("/cancel/{code}")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<?> cancelReservation(
            @PathVariable String code,
            @Valid @RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<>(
                reservationService.cancelReservation(code, reservationDTO),
                HttpStatus.OK
        );
    }
}

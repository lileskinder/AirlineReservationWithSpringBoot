package com.example.airline_reservation.Web;

import com.example.airline_reservation.Service.DTOs.ReservationDTO;
import com.example.airline_reservation.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    //    TODO: getReservations for passanger and agent only

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> getReservations(@RequestParam Optional<Integer> page) {
        List<ReservationDTO> reservationDTOList = reservationService.getReservations(page);
        return new ResponseEntity<>(reservationDTOList, HttpStatus.OK);
    }

    //    TODO: getReservation for passanger and agent only

    @GetMapping("/my")
    @PreAuthorize("hasAnyRole('PASSENGER')")
    public ResponseEntity<?> getPersonReservations(@RequestParam Optional<Integer> page, Authentication authentication) {
        String name = authentication.getName();
        return new ResponseEntity<>(
                reservationService.getPersonReservations(page, name), //name
                HttpStatus.OK
        );
    }

    //    TODO: getReservation for passanger and agent only

    @GetMapping("/{code}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> getReservation(@PathVariable String code, Authentication authentication) {
        String name = authentication.getName();
        return new ResponseEntity<>(
                reservationService.getReservationByCode(code), //name
                HttpStatus.OK
        );
    }

    //    TODO: getReservation for passanger and agent only

    @PostMapping("")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<?> postReservations(@Valid  @RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<>(
                reservationService.makeReservation(reservationDTO),
                HttpStatus.OK
        );
    }

    //    TODO: updateReservation for passanger and agent only

    @PutMapping("/{code}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> updateReservation(
            @PathVariable String code,
            @Valid @RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<>(
                reservationService.updateReservation(code, reservationDTO),
                HttpStatus.OK
        );
    }

    //    TODO: confirmReservation for passanger and agent only

    @PutMapping("/confirm/{code}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> confirmReservation(
            @PathVariable String code,
            @Valid @RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<>(
                reservationService.confirmReservation(code, reservationDTO),
                HttpStatus.OK
        );
    }

    //    TODO: cancelReservation for passanger and agent only

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

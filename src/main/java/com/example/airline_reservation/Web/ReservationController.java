package com.example.airline_reservation.Web;

import com.example.airline_reservation.Service.DTOs.ReservationDTO;
import com.example.airline_reservation.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("")
    public ResponseEntity<?> getReservations(@RequestParam Optional<Integer> page) {
        List<ReservationDTO> reservationDTOList = reservationService.getReservations(page);
        return new ResponseEntity<>(reservationDTOList, HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getReservation(@PathVariable String code) {
        return new ResponseEntity<>(
                reservationService.getReservationByCode(code),
                HttpStatus.OK
        );
    }

    @PostMapping("")
    public ResponseEntity<?> getReservations(@Valid  @RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<>(
                reservationService.makeReservation(reservationDTO),
                HttpStatus.OK
        );
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> updateReservation(
            @PathVariable String code,
            @Valid @RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<>(
                reservationService.updateReservation(code, reservationDTO),
                HttpStatus.OK
        );
    }

    @PutMapping("/confirm/{code}")
    public ResponseEntity<?> confirmReservation(
            @PathVariable String code,
            @Valid @RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<>(
                reservationService.confirmReservation(code, reservationDTO),
                HttpStatus.OK
        );
    }

    @PutMapping("/cancel/{code}")
    public ResponseEntity<?> cancelReservation(
            @PathVariable String code,
            @Valid @RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<>(
                reservationService.cancelReservation(code, reservationDTO),
                HttpStatus.OK
        );
    }
}

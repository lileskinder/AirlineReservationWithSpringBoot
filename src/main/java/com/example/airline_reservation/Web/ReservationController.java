package com.example.airline_reservation.Web;

import com.example.airline_reservation.DAO.ReservationRepo;
import com.example.airline_reservation.Model.ReservationStatus;
import com.example.airline_reservation.Service.DTOs.ReservationDTO;
import com.example.airline_reservation.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("")
    public ResponseEntity<List<ReservationDTO>> getReservations() {
        return new ResponseEntity<List<ReservationDTO>>(reservationService.getReservations(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ReservationDTO> getReservations(@PathVariable String code) {
        return new ResponseEntity<ReservationDTO>(reservationService.getReservationByCode(code), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ReservationDTO> getReservations(@RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<ReservationDTO>(reservationService.makeReservation(reservationDTO), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<ReservationDTO> updateReservation(
            @PathVariable String code, @RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<ReservationDTO>(
                reservationService.updateReservation(code, reservationDTO),
                HttpStatus.OK
        );
    }

    @PutMapping("/confirm/{code}")
    public ResponseEntity<ReservationDTO> confirmReservation(
            @PathVariable String code, @RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<ReservationDTO>(
                reservationService.confirmReservation(code, reservationDTO),
                HttpStatus.OK
        );
    }

    @PutMapping("/cancel/{code}")
    public ResponseEntity<ReservationDTO> cancelReservation(
            @PathVariable String code, @RequestBody ReservationDTO reservationDTO) {
        return new ResponseEntity<ReservationDTO>(
                reservationService.cancelReservation(code, reservationDTO),
                HttpStatus.OK
        );
    }
}

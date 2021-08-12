package com.example.airline_reservation.Web;

import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Model.Airport;
import com.example.airline_reservation.Service.DTOs.AirlineDTO;
import com.example.airline_reservation.Service.Implementation.AirlineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/airlines")
public class AirlineController {

    private final AirlineServiceImpl airlineService;

    @Autowired
    public AirlineController(AirlineServiceImpl airlineServiceImpl) {
        this.airlineService = airlineServiceImpl;
    }

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<?> getAirlines(@RequestParam Optional<Integer> page) {
        return new ResponseEntity<>(airlineService.findAll(page), HttpStatus.OK);
    }

    @GetMapping("/byid/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<?> getAirlinetById(@PathVariable int id) {
        Airline airline = airlineService.findById(id);
        return new ResponseEntity<>(airline, HttpStatus.OK);
    }

    @GetMapping("/bycode/{code}")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<?> getAirlinetByCode(@PathVariable String code) {

        Airline airline = airlineService.findByCode(code);
        return new ResponseEntity<>(airline, HttpStatus.OK);

    }

    @PostMapping("")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> addAirline(@Valid @RequestBody AirlineDTO airlineDTO) {
        AirlineDTO airline = airlineService.save(airlineDTO);
        return new ResponseEntity<>(airline, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> update(@Valid @PathVariable("id") int id, @RequestBody AirlineDTO airlinetDTO) {

        AirlineDTO airline = airlineService.Update(id, airlinetDTO);
        return new ResponseEntity<>(airline, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> deleteAirline(@Valid @PathVariable int id) {
        airlineService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/airport/{code}")
//    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<?> getAirlineFromAirport(@PathVariable String code) {
        List<AirlineDTO> airlineList = new ArrayList<>();

        for (AirlineDTO airlineDTO: airlineService.findFlightsFromAirport(code)) {
            airlineList.add(airlineDTO);
        }
        return new ResponseEntity<>(airlineList, HttpStatus.OK);
    }


}

package com.example.airline_reservation.Web;

import com.example.airline_reservation.Model.Airport;
import com.example.airline_reservation.Service.DTOs.AirportDTO;
import com.example.airline_reservation.Service.Implementation.AirportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/airports")
public class AirportController {

    private final AirportServiceImpl airportService;

    @Autowired
    public AirportController(AirportServiceImpl airportService) {
        this.airportService = airportService;
    }

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<?> getAllAirport() {
        List<AirportDTO> airport = airportService.getAllAirport();
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }


    @GetMapping("/{airportCode}")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<?> getAirportByCode(@PathVariable("airportCode") String airportCode) {
        Airport airport = airportService.getAirportByCode(airportCode);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }

    @PostMapping("")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> addAirport(@Valid  @RequestBody AirportDTO airportDTO) {
        AirportDTO airport = airportService.save(airportDTO);
        return new ResponseEntity<>(airport, HttpStatus.OK);

    }

    @PutMapping("/{airportId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> update(
            @PathVariable("airportId") int airportId,
            @Valid @RequestBody AirportDTO airportDTO
    ) {
        AirportDTO airport = airportService.Update(airportId, airportDTO);
        return new ResponseEntity<>(airport, HttpStatus.OK);

    }

    @DeleteMapping("/{airportId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> deleteAirport(@PathVariable int airportId) {
        airportService.deleteAirport(airportId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

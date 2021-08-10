package com.example.airline_reservation.Web;

import com.example.airline_reservation.Model.Airport;
import com.example.airline_reservation.Service.DTOs.AirportDTO;
import com.example.airline_reservation.Service.Implementation.AirportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<AirportDTO>> getAllAirport() {

        List<AirportDTO> airport = airportService.getAllAirport();
        return new ResponseEntity<>(airport, HttpStatus.OK);

    }

    @GetMapping("/{airportId}")
    public ResponseEntity<Airport> getAirportById(@PathVariable int airportId) {
        System.out.println("get method");
        Airport airport = airportService.getAirportById(airportId);
        return new ResponseEntity<>(airport, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<AirportDTO> addAirport(@RequestBody AirportDTO airportDTO) {
        AirportDTO airport = airportService.save(airportDTO);
        return new ResponseEntity<>(airport, HttpStatus.OK);

    }

    @PutMapping("/{airportId}")
    public ResponseEntity<AirportDTO> update(
            @PathVariable("airportId") int airportId,
            @RequestBody AirportDTO airportDTO
    ) {
        AirportDTO airport = airportService.Update(airportId, airportDTO);
        return new ResponseEntity<>(airport, HttpStatus.OK);

    }

    @DeleteMapping("/{airportId}")
    public ResponseEntity<?> deleteAirport(@PathVariable int airportId) {
        airportService.deleteAirport(airportId);
        // need to send message if airport not found
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

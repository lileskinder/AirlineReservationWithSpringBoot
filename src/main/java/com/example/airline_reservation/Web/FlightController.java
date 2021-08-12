package com.example.airline_reservation.Web;

import com.example.airline_reservation.Service.DTOs.FlightDTO;
import com.example.airline_reservation.Service.FlightService;
import com.example.airline_reservation.Service.Implementation.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    @PostMapping("")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<FlightDTO> addFlight(@RequestBody FlightDTO flightDTO) {
        return ResponseEntity.ok(flightService.addFlight(flightDTO));
    }

//    TODO: Add get flights for agent only

    @GetMapping("")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<List<FlightDTO>> getFlights(@RequestParam Optional<Integer> page) {
        return ResponseEntity.ok(flightService.findAll(page));
    }

    //    TODO: Add get flight for agent and passenger only

    @GetMapping("/{flightNumber}")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable("flightNumber") Integer flightNumber) {
        return ResponseEntity.ok(flightService.findByFlightNumber(flightNumber));
    }

    @PutMapping("/{flightNumber}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<FlightDTO> updateFlight(
            @Valid
            @PathVariable("flightNumber") Integer flightNumber,
            @RequestBody FlightDTO flightDTO
    ) {
        FlightDTO flight = flightService.updateFlight(
                flightNumber,
                flightDTO.getCapacity(),
                flightDTO.getAirlineId(),
                flightDTO.getDepartureAirportId(),
                flightDTO.getArrivalAirportId(),
                flightDTO.getDepartureTime(),
                flightDTO.getArrivalTime(),
                flightDTO.getFlightStatus()
        );
        return ResponseEntity.ok(flight);
    }

    @PatchMapping("/{flightNumber}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<FlightDTO> cancelFlight(
            @PathVariable("flightNumber") Integer flightNumber,
            @RequestBody FlightDTO flightDTO
    ) {
        FlightDTO flight = flightService.cancelFlight(
                flightNumber,
                flightDTO.getFlightStatus()
        );
        return ResponseEntity.ok(flight);
    }

    @GetMapping("/specificDate")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<List<FlightDTO>> getFlightsInSpecificDate(
            @RequestParam(value = "departureDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate
    ) {
        return ResponseEntity.ok(flightService.flightsInSpecificDate(departureDate));
    }

    @GetMapping("/flightFromAirport")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<List<FlightDTO>> getFlightsFromAirport(
            @RequestParam(value = "airportId") Integer airportId
    ) {
        return ResponseEntity.ok(flightService.findFlightsFromAirport(airportId));
    }
}

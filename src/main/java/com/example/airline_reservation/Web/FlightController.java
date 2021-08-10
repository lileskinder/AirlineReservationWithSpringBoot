package com.example.airline_reservation.Web;

import com.example.airline_reservation.Service.DTOs.FlightDTO;
import com.example.airline_reservation.Service.FlightService;
import com.example.airline_reservation.Service.Implementation.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightServiceImpl flightService) {
        this.flightService = flightService;
    }

    @PostMapping("")
    public ResponseEntity<FlightDTO> addFlight(@RequestBody FlightDTO flightDTO) {
        FlightDTO flight = flightService.addFlight(flightDTO);
        try {
            if (flight != null) {
                return new ResponseEntity<>(flight, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.valueOf("Something went wrong!!!"));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(HttpStatus.BAD_REQUEST + e.getMessage()));
        }

    }

    @GetMapping("")
    public ResponseEntity<List<FlightDTO>> getFlights() {
        try {
            if (flightService.findAll() != null) {
                return new ResponseEntity<>(flightService.findAll(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.valueOf("Something went wrong!!!"));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(HttpStatus.BAD_REQUEST + e.getMessage()));
        }
    }

    @GetMapping("/{flightNumber}")
    public ResponseEntity<FlightDTO> getFlight(@PathVariable("flightNumber") Integer flightNumber) {
        FlightDTO flight = flightService.findByFlightNumber(flightNumber);
        try {
            if (flight != null) {
                return new ResponseEntity<>(flight, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.valueOf("Something went wrong!!!"));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(HttpStatus.BAD_REQUEST + e.getMessage()));
        }
    }

    @PutMapping("/{flightNumber}")
    public ResponseEntity<FlightDTO> updateFlight(
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
        try {
            if (flight != null) {
                return new ResponseEntity<>(flight, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.valueOf("Something went wrong!!!"));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(HttpStatus.BAD_REQUEST + e.getMessage()));
        }

    }

    @PatchMapping("/{flightNumber}")
    public ResponseEntity<FlightDTO> cancelFlight(
            @PathVariable("flightNumber") Integer flightNumber,
            @RequestBody FlightDTO flightDTO
    ) {
        FlightDTO flight = flightService.cancelFlight(
                flightNumber,
                flightDTO.getFlightStatus()
        );
        try {
            if (flight != null) {
                return new ResponseEntity<>(flight, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.valueOf("Something went wrong!!!"));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(HttpStatus.BAD_REQUEST + e.getMessage()));
        }
    }

    @GetMapping("/specificDate")
    public ResponseEntity<List<FlightDTO>> getFlightsInSpecificDate(
            @RequestParam(value = "departureDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate
    ) {
        try {
            if (flightService.flightsInSpecificDate(departureDate) != null) {
                return new ResponseEntity<>(flightService.flightsInSpecificDate(departureDate), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.valueOf("Something went wrong!!!"));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(HttpStatus.BAD_REQUEST + e.getMessage()));
        }
    }

    @GetMapping("/flightFromAirport")
    public ResponseEntity<List<FlightDTO>> getFlightsFromAirport(
            @RequestParam(value = "airportId") Integer airportId
    ) {
        try {
            if (flightService.findFlightsFromAirport(airportId) != null) {
                return new ResponseEntity<>(flightService.findFlightsFromAirport(airportId), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.valueOf("Something went wrong!!!"));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(HttpStatus.BAD_REQUEST + e.getMessage()));
        }
    }
}

package com.example.airline_reservation.Web;

import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Service.DTOs.AirlineDTO;
import com.example.airline_reservation.Service.Implementation.AirlineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<AirlineDTO>> getAirlines(@RequestParam Optional<Integer> page) {
        try {
            if (airlineService.findAll(page) != null) {
                return new ResponseEntity<>(airlineService.findAll(page), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.valueOf("Error happened!!!"));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(HttpStatus.BAD_REQUEST + e.getMessage()));
        }
    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<Airline> getAirlinetById(@PathVariable int id) {

        Airline airline = airlineService.findById(id);

        try {
            if (airline != null) {
                return new ResponseEntity<>(airline, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.valueOf("Something went wrong!!!"));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(HttpStatus.BAD_REQUEST + e.getMessage()));
        }
    }

    @GetMapping("/bycode/{code}")
    public ResponseEntity<Airline> getAirlinetByCode(@PathVariable String code) {

        Airline airline = airlineService.findByCode(code);

        try {
            if (airline != null) {
                return new ResponseEntity<>(airline, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.valueOf("Something went wrong!!!"));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(HttpStatus.BAD_REQUEST + e.getMessage()));
        }
    }

    @PostMapping("")
    public ResponseEntity<AirlineDTO> addAirline(@RequestBody AirlineDTO airlineDTO) {

        Optional<Airline> AirOptional = Optional.ofNullable(airlineService.findByCode(airlineDTO.getCode()));
        if (AirOptional.isPresent()) {
            throw new IllegalStateException("code taken");
        }
        AirlineDTO airline = airlineService.save(airlineDTO);

        try {
            if (airline != null) {
                return new ResponseEntity<>(airline, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.valueOf("Something went wrong!!!"));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(HttpStatus.BAD_REQUEST + e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirlineDTO> update(@PathVariable("id") int id, @RequestBody AirlineDTO airlinetDTO) {

        AirlineDTO airline = airlineService.Update(id, airlinetDTO);
        try {
            if (airline != null) {
                return new ResponseEntity<>(airline, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.valueOf("Something went wrong!!!"));
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.valueOf(HttpStatus.BAD_REQUEST + e.getMessage()));
        }


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAirline(@PathVariable int id) {
        airlineService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

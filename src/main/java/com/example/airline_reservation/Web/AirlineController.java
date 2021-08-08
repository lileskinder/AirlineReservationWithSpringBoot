package com.example.airline_reservation.Web;

import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Service.Implementation.AirlineServiceImpl;
import com.example.airline_reservation.Web.DTOs.AirlineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class AirlineController {

    @Autowired
    AirlineServiceImpl airlineService;

    @GetMapping("/airlines")
    public ResponseEntity<List<AirlineDTO>> getAirlines() {
        List<AirlineDTO> airlines = airlineService.findAll();

        return new ResponseEntity<List<AirlineDTO>>(airlines, HttpStatus.OK);
    }
    @GetMapping("/airlinesbyid/{id}")
    public ResponseEntity<Airline> getAirlinetById(@PathVariable int id) {
        int size=airlineService.findAll().size();
        if (id>=size || id<0){
            System.out.println("Cannot find");
            throw new AirlineNotFoundException("Airline Id Not found:-"+id);
        }
        System.out.println("get method");
        Airline airline = airlineService.findById(id);

        return new ResponseEntity<>(airline, HttpStatus.OK);
    }

    @GetMapping("/airlinesbycode/{code}")
    public ResponseEntity<Airline> getAirlinetByCode(@PathVariable String code) {

        Airline airline = airlineService.findByCode(code);
//
        System.out.println("is?"+airline.equals(null));
        return new ResponseEntity<>(airline, HttpStatus.OK);
    }

    @PostMapping("/airlines")
    public ResponseEntity<AirlineDTO> addAirline(@RequestBody AirlineDTO airlineDTO) {

        Optional<Airline> AirOptional = Optional.ofNullable(airlineService.findByCode(airlineDTO.getCode()));

        if(AirOptional.isPresent()) {
            throw new IllegalStateException("code taken");
        }
        AirlineDTO aline = airlineService.save(airlineDTO);

        return new ResponseEntity<AirlineDTO>(aline, HttpStatus.OK);
    }

    @PutMapping("airlines/{id}")
    public ResponseEntity<AirlineDTO> update( @PathVariable("id") int id,  @RequestBody AirlineDTO airlinetDTO) {

        AirlineDTO airline = airlineService.Update(id, airlinetDTO);
        return new ResponseEntity<>(airline, HttpStatus.OK);

    }

    @DeleteMapping("/airlines/{id}")
    public ResponseEntity<?> deleteAirline(@PathVariable int id) {
        airlineService.delete(id);
        // need to send message if airport not found
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    public ResponseEntity<AirlineErrorResponse> handleException(AirlineNotFoundException exec){
        AirlineErrorResponse err = new AirlineErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
         err.setMessage(exec.getMessage());
         err.setTimestamp(System.currentTimeMillis());

            return  new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }

}

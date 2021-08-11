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


    @GetMapping("/{airportCode}")
    public ResponseEntity<Airport> getAirportByCode(@PathVariable("airportCode") String airportCode) {
        Airport airport = airportService.getAirportByCode(airportCode);
        try{
            if(airport != null){
                return new ResponseEntity<>(airport, HttpStatus.OK);
            }
            else{
                return  new ResponseEntity<>(HttpStatus.valueOf("Something went wrong!!!"));
            }
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.valueOf(HttpStatus.BAD_REQUEST + e.getMessage()));
        }
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

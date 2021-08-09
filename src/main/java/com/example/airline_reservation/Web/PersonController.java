package com.example.airline_reservation.Web;

import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Service.DTOs.PassengerDTO;
import com.example.airline_reservation.Service.Implementation.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PassengerServiceImpl passengerService;

    @PostMapping("/passengers")
    public ResponseEntity<PassengerDTO> addPassenger(@RequestBody PassengerDTO passenger) {
        return new ResponseEntity<PassengerDTO>(passengerService.addPassenger(passenger), HttpStatus.OK);
    }
}

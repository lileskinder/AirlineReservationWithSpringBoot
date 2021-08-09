package com.example.airline_reservation.Web;

import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Service.Implementation.PersonServiceImpl;
import com.example.airline_reservation.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonServiceImpl personService;

    @PostMapping("/persons")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return new ResponseEntity<Person>(personService.addPerson(person), HttpStatus.OK);
    }
}

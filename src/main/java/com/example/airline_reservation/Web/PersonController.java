package com.example.airline_reservation.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.airline_reservation.Service.Implementation.PersonServiceImpl;
import com.example.airline_reservation.Web.DTOs.PersonDTO;

@RestController
public class PersonController {

	@Autowired
	PersonServiceImpl personService;

	@GetMapping("/people")
	public ResponseEntity<List<PersonDTO>> getPeople() {
		List<PersonDTO> people = personService.getPassengers();

		return new ResponseEntity<List<PersonDTO>>(people, HttpStatus.OK);
	}
/*
	@PostMapping("/people")
	public ResponseEntity<PersonDTO> addPassenger(@RequestBody PersonDTO personDTO) {
		PersonDTO person = personService.addPassanger(personDTO);

		return new ResponseEntity<PersonDTO>(person, HttpStatus.OK);
	}*/
}
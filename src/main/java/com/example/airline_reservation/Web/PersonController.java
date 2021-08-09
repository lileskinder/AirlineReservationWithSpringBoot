package com.example.airline_reservation.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.airline_reservation.Service.Implementation.PersonServiceImpl;
import com.example.airline_reservation.Web.DTOs.PersonDTO;

@RestController
public class PersonController {

	@Autowired
	PersonServiceImpl personService;

	@GetMapping("/passengers")
	public ResponseEntity<List<PersonDTO>> getPassengers() {
		List<PersonDTO> people = personService.getPassengers();

		return new ResponseEntity<List<PersonDTO>>(people, HttpStatus.OK);
	}

	@PostMapping("/passengers")
	public ResponseEntity<PersonDTO> addPassenger(@RequestBody PersonDTO personDTO) {
		PersonDTO person = personService.addPassenger(personDTO);

		return new ResponseEntity<PersonDTO>(person, HttpStatus.OK);
	}

	@PostMapping("/passengers/{id}/update")
	public ResponseEntity<PersonDTO> updatePassenger(@RequestBody PersonDTO personDTO) {
		PersonDTO person = personService.addPassenger(personDTO);

		return new ResponseEntity<PersonDTO>(person, HttpStatus.OK);
	}

	@GetMapping("/passengers/{id}")
	public PersonDTO getPassengerById(@PathVariable int id) {
		return personService.getPassengerById(id);
	}

	@PostMapping("/passengers/{id}/delete")
	public ResponseEntity<PersonDTO> deletePassenger(@RequestBody int passengerId) {
		personService.deletePassenger(passengerId);

		return new ResponseEntity(HttpStatus.OK);
	}
}
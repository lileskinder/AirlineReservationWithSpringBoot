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
import com.example.airline_reservation.Service.DTOs.PersonDTO;

@RestController
public class PersonController {

	@Autowired
	PersonServiceImpl personService;

	// PASSENGER
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

	@PostMapping("/passengers/update")
	public ResponseEntity<PersonDTO> updatePassenger(@RequestBody PersonDTO personDTO) {
		PersonDTO person = personService.updatePassenger(personDTO);

		return new ResponseEntity<PersonDTO>(person, HttpStatus.OK);
	}

	@GetMapping("/passengers/{id}")
	public ResponseEntity<PersonDTO> getPassengerById(@PathVariable(name = "id") int id) {
		return new ResponseEntity<PersonDTO>(personService.getPassengerById(id), HttpStatus.OK);
	}

	@PostMapping("/passengers/delete")
	public ResponseEntity<PersonDTO> deletePassenger(@RequestBody PersonDTO personDTO) {
		personService.deletePassenger(personDTO.getId());

		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/passengers/{id}/delete")
	public ResponseEntity<PersonDTO> deletePassengerById(@PathVariable(name = "id") int id) {
		personService.deletePassenger(id);

		return new ResponseEntity(HttpStatus.OK);
	}

	// AGENT
	@GetMapping("/agents")
	public ResponseEntity<List<PersonDTO>> getAgents() {
		List<PersonDTO> people = personService.getAgents();

		return new ResponseEntity<List<PersonDTO>>(people, HttpStatus.OK);
	}

	@PostMapping("/agents")
	public ResponseEntity<PersonDTO> addAgent(@RequestBody PersonDTO personDTO) {
		PersonDTO person = personService.addAgent(personDTO);
		return new ResponseEntity<PersonDTO>(person, HttpStatus.OK);
	}

	@PostMapping("/agents/update")
	public ResponseEntity<PersonDTO> updateAgent(@RequestBody PersonDTO personDTO) {
		PersonDTO person = personService.updateAgent(personDTO);

		return new ResponseEntity<PersonDTO>(person, HttpStatus.OK);
	}

	@GetMapping("/agents/{id}")
	public ResponseEntity<PersonDTO> getAgentById(@PathVariable(name = "id") int id) {
		return new ResponseEntity<PersonDTO>(personService.getAgentById(id), HttpStatus.OK);
	}

	@PostMapping("/agents/delete")
	public ResponseEntity<PersonDTO> deleteAgent(@RequestBody PersonDTO personDTO) {
		personService.deletePassenger(personDTO.getId());

		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/agents/{id}/delete")
	public ResponseEntity<PersonDTO> deleteAgent(@PathVariable(name = "id") int id) {
		personService.deletePassenger(id);

		return new ResponseEntity(HttpStatus.OK);
	}
}
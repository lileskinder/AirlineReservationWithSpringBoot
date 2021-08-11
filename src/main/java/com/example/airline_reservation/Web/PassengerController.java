package com.example.airline_reservation.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airline_reservation.Service.PassengerService;
import com.example.airline_reservation.Service.DTOs.PassengerDTO;
import com.example.airline_reservation.Service.DTOs.PersonDTO;

import javax.validation.Valid;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

	final PassengerService service;

	@Autowired
	public PassengerController(PassengerService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<?> getPassengers() {
		List<PassengerDTO> passengers = service.getPassengers();
		return new ResponseEntity<List<PassengerDTO>>(passengers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getPassengerById(@PathVariable(name = "id") int id) {
		return new ResponseEntity<PersonDTO>(service.getPassengerById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addPassenger(@Valid @RequestBody PassengerDTO passengerDTO) {
		System.out.println(passengerDTO);
		return new ResponseEntity<PassengerDTO>(service.addPassenger(passengerDTO), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updatePassenger(@Valid @RequestBody PassengerDTO passengerDTO) {
		return new ResponseEntity<PassengerDTO>(service.updatePassenger(passengerDTO), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> deletePassenger(@Valid @RequestBody PersonDTO personDTO) {
		service.deletePassenger(personDTO.getId());
		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePassengerById(@PathVariable(name = "id") int id) {
		service.deletePassenger(id);
		return new ResponseEntity(HttpStatus.OK);
	}

}
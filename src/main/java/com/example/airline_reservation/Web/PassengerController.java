package com.example.airline_reservation.Web;

import com.example.airline_reservation.Service.DTOs.PassengerDTO;
import com.example.airline_reservation.Service.DTOs.PersonDTO;
import com.example.airline_reservation.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
		return new ResponseEntity<>(passengers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getPassengerById(@PathVariable(name = "id") int id) {
		return new ResponseEntity<PersonDTO>(service.getPassengerById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> addPassenger(@Valid @RequestBody PassengerDTO passengerDTO) {
		return new ResponseEntity<>(service.addPassenger(passengerDTO), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updatePassenger(@Valid @RequestBody PassengerDTO passengerDTO) {
		return new ResponseEntity<>(service.updatePassenger(passengerDTO), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> deletePassenger(@Valid @RequestBody PersonDTO personDTO) {
		service.deletePassenger(personDTO.getId());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")

	public ResponseEntity<?> deletePassengerById(@PathVariable(name = "id") int id) {
		service.deletePassenger(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
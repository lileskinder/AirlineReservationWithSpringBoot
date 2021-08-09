package com.example.airline_reservation.Web;

import com.example.airline_reservation.Model.Airline;
import com.example.airline_reservation.Service.Implementation.AirlineServiceImpl;
import com.example.airline_reservation.Service.DTOs.AirlineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AirlineController {

	@Autowired
	AirlineServiceImpl airlineService;

	@GetMapping("/airlines")
	public ResponseEntity<List<AirlineDTO>> getAirlines() {
		List<AirlineDTO> airlines = airlineService.findAll();

		return new ResponseEntity<List<AirlineDTO>>(airlines, HttpStatus.OK);
	}

	@PostMapping("/airlines")
	public ResponseEntity<AirlineDTO> addAirline(@RequestBody AirlineDTO airlineDTO) {
		AirlineDTO aline = airlineService.save(airlineDTO);

		return new ResponseEntity<AirlineDTO>(aline, HttpStatus.OK);
	}

}

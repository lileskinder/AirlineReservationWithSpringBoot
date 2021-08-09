package com.example.airline_reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.airline_reservation.Service.PersonService;
import com.example.airline_reservation.Service.Implementation.PersonServiceImpl;

@SpringBootApplication
public class AirlineReservationApplication {

	static PersonService personService = new PersonServiceImpl();

	public static void main(String[] args) {

		SpringApplication.run(AirlineReservationApplication.class, args);

//		System.out.println(personService.getPassengers());
	}
}

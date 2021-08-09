package com.example.airline_reservation.Web.DTOs.DTOAdapters;

import com.example.airline_reservation.Model.Passenger;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Web.DTOs.PersonDTO;

public class PersonDTOAdapter {
	public static Person getPerson(PersonDTO personDTO) {
		Person person = new Person();

		person.setId(personDTO.getId());
		person.setFirstName(personDTO.getFirstName());
		person.setLastName(personDTO.getLastName());
		person.setEmail(personDTO.getEmail());
		person.setAddress(personDTO.getAddress());
		person.setDob(personDTO.getDob());
		person.setAgentId(personDTO.getAgentId());
		return person;
	}

	public static Passenger getPassenger(PersonDTO personDTO) {
		Passenger passenger = new Passenger();

		passenger.setId(personDTO.getId());
		passenger.setFirstName(personDTO.getFirstName());
		passenger.setLastName(personDTO.getLastName());
		passenger.setEmail(personDTO.getEmail());
		passenger.setAddress(personDTO.getAddress());
		passenger.setDob(personDTO.getDob());
		return passenger;
	}
S
	public static PersonDTO getPersonDTO(Person person) {
		PersonDTO personDTO = new PersonDTO();

		personDTO.setId(person.getId());
		personDTO.setFirstName(person.getFirstName());
		personDTO.setLastName(person.getLastName());
		personDTO.setEmail(person.getEmail());
		personDTO.setAddress(person.getAddress());

		personDTO.setDob(person.getDob());
		personDTO.setAgentId(person.getAgentId());
		return personDTO;
	}
}

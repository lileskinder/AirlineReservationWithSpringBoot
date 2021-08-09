package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import java.util.Optional;

import com.example.airline_reservation.Model.Admin;
import com.example.airline_reservation.Model.Agent;
import com.example.airline_reservation.Model.Passenger;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Service.DTOs.PersonDTO;

public class PersonDTOAdapter {
	public static Person getAdmin(PersonDTO adminDTO) {
		Admin admin = new Admin();

		admin.setFirstName(adminDTO.getFirstName());
		admin.setLastName(adminDTO.getLastName());
		admin.setEmail(adminDTO.getEmail());
		admin.setAddress(adminDTO.getAddress());

		return admin;
	}

	public static Person getPassenger(PersonDTO passengerDTO) {
		Passenger passenger = new Passenger();

		passenger.setFirstName(passengerDTO.getFirstName());
		passenger.setLastName(passengerDTO.getLastName());
		passenger.setEmail(passengerDTO.getEmail());
		passenger.setAddress(passengerDTO.getAddress());
		passenger.setDob(passengerDTO.getDob());

		return passenger;
	}

	public static Person getAgent(PersonDTO agentDTO) {
		Agent agent = new Agent();

		agent.setFirstName(agentDTO.getFirstName());
		agent.setLastName(agentDTO.getLastName());
		agent.setEmail(agentDTO.getEmail());
		agent.setAddress(agentDTO.getAddress());
		agent.setAgentId(agentDTO.getAgentId());

		return agent;
	}

	public static PersonDTO getAdminDTO(Admin admin) {
		PersonDTO personDTO = new PersonDTO();

		personDTO.setFirstName(admin.getFirstName());
		personDTO.setLastName(admin.getLastName());
		personDTO.setEmail(admin.getEmail());
		personDTO.setAddress(admin.getAddress());

		return personDTO;
	}

	public static PersonDTO getPassengerDTO(Passenger passenger) {
		PersonDTO personDTO = new PersonDTO();

		personDTO.setFirstName(passenger.getFirstName());
		personDTO.setLastName(passenger.getLastName());
		personDTO.setEmail(passenger.getEmail());
		personDTO.setAddress(passenger.getAddress());
		personDTO.setDob(passenger.getDob());

		return personDTO;
	}

	public static PersonDTO getAgentDTO(Agent agent) {
		PersonDTO personDTO = new PersonDTO();

		personDTO.setFirstName(agent.getFirstName());
		personDTO.setLastName(agent.getLastName());
		personDTO.setEmail(agent.getEmail());
		personDTO.setAddress(agent.getAddress());

		personDTO.setAgentId(agent.getAgentId());

		return personDTO;
	}
}

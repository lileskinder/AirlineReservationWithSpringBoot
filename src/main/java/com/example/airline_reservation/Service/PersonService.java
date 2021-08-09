package com.example.airline_reservation.Service;

import java.util.List;

import com.example.airline_reservation.Model.Agent;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Service.DTOs.PersonDTO;
import com.example.airline_reservation.Model.Passenger;

public interface PersonService {

	public void deletePassenger(int passengerId);

	public List<PersonDTO> getPassengers();

	public PersonDTO getPassengerById(int passengerId);

	public PersonDTO addAgent(PersonDTO agent);

	public PersonDTO updateAgent(PersonDTO personDTO);

	public void deleteAgent(int agentId);

	public List<PersonDTO> getAgents();

	public PersonDTO getAgentById(int agentId);

	public PersonDTO addPassenger(PersonDTO personDTO);

	public PersonDTO updatePassenger(PersonDTO personDTO);
}

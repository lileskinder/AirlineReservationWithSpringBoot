package com.example.airline_reservation.Service;

import java.util.List;

import com.example.airline_reservation.Model.Agent;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Web.DTOs.PersonDTO;
import com.example.airline_reservation.Model.Passenger;

public interface PersonService {


	public void updatePassanger(int passangerId);

	public void deletePassanger(int passangerId);

	public List<PersonDTO> getPassengers();

	public Person getPassangerById(String passangerId);

	public void addAgent(Person agent);

	public void updateAgent(int agentId);

	public void deleteAgent(int agentId);

	public List<Person> getAgents();

	public Person getagentById(int agentId);

	void addPassanger(PersonDTO personDTO);
}

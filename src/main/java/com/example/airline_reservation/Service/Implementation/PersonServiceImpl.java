package com.example.airline_reservation.Service.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.airline_reservation.DAO.PersonRepo;
import com.example.airline_reservation.Model.Agent;
import com.example.airline_reservation.Model.Passenger;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Service.PersonService;
import com.example.airline_reservation.Service.DTOs.PersonDTO;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.PersonDTOAdapter;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonRepo repo;

	@Override
	public PersonDTO addPassenger(PersonDTO personDTO) {
		Passenger passenger = PersonDTOAdapter.getPassenger(personDTO);
		return PersonDTOAdapter.getPassengerDTO(repo.save(passenger));
	}

	@Override
	public List<PersonDTO> getPassengers() {
		List<Person> people = repo.findAll();

		List<PersonDTO> PersonDTOList = new ArrayList<>();

		for (Person person : people) {
			PersonDTOList.add(PersonDTOAdapter.getPassengerDTO(person));
		}

		return PersonDTOList;
	}

	@Override
	public PersonDTO updatePassenger(PersonDTO personDTO) {
		Passenger passenger = PersonDTOAdapter.getPassenger(personDTO);
		return PersonDTOAdapter.getPassengerDTO(repo.save(passenger));
	}

	@Override
	public void deletePassenger(int passengerId) {
		if (!repo.existsById(passengerId)) {
			throw new IllegalStateException("Passenger with id " + passengerId + " does not exists");
		}
		repo.deleteById(passengerId);
	}

	@Override
	public PersonDTO getPassengerById(int passengerId) {
		Optional<Person> person = repo.findById(passengerId);
		return PersonDTOAdapter.getPassengerDTO(person);
	}

	@Override
	public PersonDTO addAgent(PersonDTO personDTO) {
		Agent agent = PersonDTOAdapter.getAgent(personDTO);
		return PersonDTOAdapter.getAgentDTO(repo.save(agent));

	}

	@Override
	public PersonDTO updateAgent(PersonDTO personDTO) {
		// TODO Auto-generated method stub
		Agent agent = PersonDTOAdapter.getAgent(personDTO);
		return PersonDTOAdapter.getAgentDTO(repo.save(agent));
	}

	@Override
	public void deleteAgent(int agentId) {
		if (!repo.existsById(agentId)) {
			throw new IllegalStateException("Agent with id " + agentId + " does not exists");
		}
		repo.deleteById(agentId);
	}

	@Override
	public List<PersonDTO> getAgents() {
		List<Person> people = repo.findAll();

		List<PersonDTO> PersonDTOList = new ArrayList<>();

		for (Person person : people) {
			PersonDTOList.add(PersonDTOAdapter.getPersonDTO(person));
		}

		return PersonDTOList;
	}

	@Override
	public PersonDTO getAgentById(int agentId) {
		Optional<Person> person = repo.findById(agentId);
		return PersonDTOAdapter.getPersonDTO(person);
	}

}

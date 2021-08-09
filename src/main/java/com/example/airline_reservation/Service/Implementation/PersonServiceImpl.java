package com.example.airline_reservation.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.airline_reservation.DAO.PersonRepo;
import com.example.airline_reservation.Model.Agent;
import com.example.airline_reservation.Model.Passenger;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Service.PersonService;
import com.example.airline_reservation.Web.DTOs.PersonDTO;
import com.example.airline_reservation.Web.DTOs.DTOAdapters.PersonDTOAdapter;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonRepo repo;

	@Override
	public void addPassanger(PersonDTO personDTO) {
		Passenger passanger = PersonDTOAdapter.getPassenger(personDTO);
		repo.save(passanger);
	}

	@Override
	public List<PersonDTO> getPassengers() {
		List<Person> people = repo.findAll();

		List<PersonDTO> PersonDTOList = new ArrayList<>();

		for (Person person : people) {
			PersonDTOList.add(PersonDTOAdapter.getPersonDTO(person));
		}

		return PersonDTOList;
	}

	@Override
	public void updatePassanger(int passangerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePassanger(int passangerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Person getPassangerById(String passangerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAgent(Person agent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAgent(int agentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAgent(int agentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Person> getAgents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agent getagentById(int agentId) {
		// TODO Auto-generated method stub
		return null;
	}

}

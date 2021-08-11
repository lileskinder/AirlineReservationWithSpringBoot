package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.PassengerRepo;
import com.example.airline_reservation.DAO.RoleRepo;
import com.example.airline_reservation.Model.Passenger;
import com.example.airline_reservation.Model.Role;
import com.example.airline_reservation.Model.RoleType;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.PassengerDTOAdapter;
import com.example.airline_reservation.Service.DTOs.PassengerDTO;
import com.example.airline_reservation.Service.PassengerService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
	private final String NOT_FOUND_PASSENGER = " passenger does not exists";
	private final PassengerRepo passengerRepo;
	private final RoleRepo roleRepo;

	@Autowired
	public PassengerServiceImpl(PassengerRepo passengerRepo, RoleRepo roleRepo) {
		this.passengerRepo = passengerRepo;
		this.roleRepo = roleRepo;
	}

	@Override
	public PassengerDTO addPassenger(PassengerDTO passengerDTO) {
		Passenger passenger = PassengerDTOAdapter.getPassenger(passengerDTO);
		Role role = PassengerDTOAdapter.getRole(passengerDTO);

		passenger = passengerRepo.save(passenger);
		role.setPersonId(passenger.getId());
		role.setRole(RoleType.PASSENGER.toString());
		role = roleRepo.save(role);
		return PassengerDTOAdapter.getPassengerDTO(passenger, role);
	}

	@Override
	public PassengerDTO getPassengerById(int id) {
		Passenger passenger = passengerRepo.findById(id)
				.orElseThrow(() -> new IllegalStateException(id + NOT_FOUND_PASSENGER));
		Role role = roleRepo.findTopByPersonRoleName(id, RoleType.PASSENGER.toString());
		return PassengerDTOAdapter.getPassengerDTO(passenger, role);
	}

	@Override
	public PassengerDTO updatePassenger(PassengerDTO PassengerDTO) {
		Passenger passenger = PassengerDTOAdapter.getPassenger(PassengerDTO);

		Role role = roleRepo.findTopByPersonRoleName(PassengerDTO.getId(), RoleType.PASSENGER.toString());
		return PassengerDTOAdapter.getPassengerDTO(passengerRepo.save(passenger), role);
	}

	@Override
	public void deletePassenger(int id) {
		if (!passengerRepo.existsById(id)) {
			throw new IllegalStateException(id + NOT_FOUND_PASSENGER);
		}
		// Delete roles
		List<Role> roles = roleRepo.findByPerson(id);
		for (Role r : roles) {
			roleRepo.deleteById(r.getId());
		}

		passengerRepo.deleteById(id);
	}

	@Override
	public List<PassengerDTO> getPassengers() {
		List<Passenger> passengers = passengerRepo.findAll();
		List<PassengerDTO> PassengerDTOList = new ArrayList<>();

		for (Passenger passenger : passengers) {
			Role role = roleRepo.findTopByPersonRoleName(passenger.getId(), RoleType.PASSENGER.toString());
			PassengerDTOList.add(PassengerDTOAdapter.getPassengerDTO(passenger, role));
		}

		return PassengerDTOList;
	}
}

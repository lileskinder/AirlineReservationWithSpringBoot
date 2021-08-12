package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.PassengerRepo;
import com.example.airline_reservation.ExceptionHandling.ResourceNotFoundException;
import com.example.airline_reservation.Model.Passenger;
import com.example.airline_reservation.Model.Role;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.PassengerDTOAdapter;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.RoleDTOAdapter;
import com.example.airline_reservation.Service.DTOs.PassengerDTO;
import com.example.airline_reservation.Service.DTOs.RoleDTO;
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

	@Autowired
	public PassengerServiceImpl(PassengerRepo passengerRepo) {
		this.passengerRepo = passengerRepo;
	}

	@Override
	public PassengerDTO addPassenger(PassengerDTO passengerDTO) {
		Passenger passenger = PassengerDTOAdapter.getPassenger(passengerDTO);
		return PassengerDTOAdapter.getPassengerDTO(passengerRepo.save(passenger));
	}

	@Override
	public PassengerDTO getPassengerById(int id) {
		Passenger passenger = passengerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(id + NOT_FOUND_PASSENGER));
		return PassengerDTOAdapter.getPassengerDTO(passenger);
	}

	@Override
	public PassengerDTO updatePassenger(PassengerDTO PassengerDTO) {
		Passenger passenger = PassengerDTOAdapter.getPassenger(PassengerDTO);
		return PassengerDTOAdapter.getPassengerDTO(passengerRepo.save(passenger));
	}

	@Override
	public void deletePassenger(int id) {
		if (!passengerRepo.existsById(id)) {
			throw new ResourceNotFoundException(id + NOT_FOUND_PASSENGER);
		}

		passengerRepo.deleteById(id);
	}

	@Override
	public List<PassengerDTO> getPassengers() {
		List<Passenger> passengers = passengerRepo.findAll();
		List<PassengerDTO> PassengerDTOList = new ArrayList<>();

		for (Passenger passenger : passengers) {
			PassengerDTOList.add(PassengerDTOAdapter.getPassengerDTO(passenger));
		}

		return PassengerDTOList;
	}

	@Override
	public List<RoleDTO> getPassengerRoles(int passengerId) {

		Passenger passenger = passengerRepo.findById(passengerId)
				.orElseThrow(() -> new ResourceNotFoundException(passengerId + NOT_FOUND_PASSENGER));

		List<Role> roles = passenger.getRoles();
		List<RoleDTO> roleDTOList = new ArrayList<>();

		for (Role role : roles) {
			roleDTOList.add(RoleDTOAdapter.getRoleDTO(role));
		}

		return roleDTOList;
	}
}

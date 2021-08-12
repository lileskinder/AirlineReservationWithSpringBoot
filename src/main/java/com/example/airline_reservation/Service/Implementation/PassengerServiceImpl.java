package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.PassengerRepo;
import com.example.airline_reservation.Model.Passenger;
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
				.orElseThrow(() -> new IllegalStateException("Passenger with id " + id + " does not exists"));
		return PassengerDTOAdapter.getPassengerDTO(passenger);
	}

	@Override
	public PassengerDTO updatePassenger(PassengerDTO PassengerDTO) {
		Passenger passenger = PassengerDTOAdapter.getPassenger(PassengerDTO);
		return PassengerDTOAdapter.getPassengerDTO(passengerRepo.save(passenger));

	}

	@Override
	public void deletePassenger(int passengerId) {
		if (!passengerRepo.existsById(passengerId)) {
			throw new IllegalStateException("Passenger with id " + passengerId + " does not exists");
		}
		passengerRepo.deleteById(passengerId);
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


}

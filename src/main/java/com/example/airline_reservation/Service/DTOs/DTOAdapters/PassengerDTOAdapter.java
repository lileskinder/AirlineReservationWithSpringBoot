package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import java.util.ArrayList;
import java.util.List;

import com.example.airline_reservation.Model.Passenger;
import com.example.airline_reservation.Model.Role;
import com.example.airline_reservation.Service.DTOs.PassengerDTO;
import com.example.airline_reservation.Service.DTOs.RoleDTO;

public class PassengerDTOAdapter {

	public static Passenger getPassenger(PassengerDTO passengerDTO) {
		Passenger passenger = new Passenger();
		if (passengerDTO != null) {
			passenger.setId(passengerDTO.getId());
			passenger.setFirstName(passengerDTO.getFirstName());
			passenger.setLastName(passengerDTO.getLastName());
			passenger.setEmail(passengerDTO.getEmail());
			passenger.setAddress(passengerDTO.getAddress());
			passenger.setDob(passengerDTO.getDob());

			passenger.setUserName(passengerDTO.getUserName());
			if (passengerDTO.getRoles() != null)
				for (RoleDTO r : passengerDTO.getRoles()) {
					r.setUserName(passengerDTO.getUserName());
					passenger.getRoles().add(RoleDTOAdapter.getRole(r));
				}
		}

		return passenger;
	}

	public static PassengerDTO getPassengerDTO(Passenger passenger) {
		PassengerDTO passengerDTO = new PassengerDTO();

		if (passenger != null) {
			passengerDTO.setId(passenger.getId());
			passengerDTO.setFirstName(passenger.getFirstName());
			passengerDTO.setLastName(passenger.getLastName());
			passengerDTO.setEmail(passenger.getEmail());
			passengerDTO.setAddress(passenger.getAddress());
			passengerDTO.setDob(passenger.getDob());

			passengerDTO.setUserName(passenger.getUserName());
			if (passenger.getRoles() != null)
				for (Role r : passenger.getRoles()) {
					passengerDTO.getRoles().add(RoleDTOAdapter.getRoleDTO(r));
				}
		}
		return passengerDTO;
	}
}

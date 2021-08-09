package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.Model.Admin;
import com.example.airline_reservation.Model.Agent;
import com.example.airline_reservation.Model.Passenger;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Service.DTOs.PassengerDTO;

public class PassengerDTOAdapter {


	public static Passenger getPassenger(PassengerDTO passengerDTO) {
		Passenger passenger = new Passenger();

		passenger.setFirstName(passengerDTO.getFirstName());
		passenger.setLastName(passengerDTO.getLastName());
		passenger.setEmail(passengerDTO.getEmail());
		passenger.setAddress(passengerDTO.getAddress());
		passenger.setDob(passengerDTO.getDob());

		return passenger;
	}





	public static PassengerDTO getPassengerDTO(Passenger passenger) {
		PassengerDTO passengerDTO = new PassengerDTO();

		passengerDTO.setFirstName(passenger.getFirstName());
		passengerDTO.setLastName(passenger.getLastName());
		passengerDTO.setEmail(passenger.getEmail());
		passengerDTO.setAddress(passenger.getAddress());
		passengerDTO.setDob(passenger.getDob());

		return passengerDTO;
	}


}
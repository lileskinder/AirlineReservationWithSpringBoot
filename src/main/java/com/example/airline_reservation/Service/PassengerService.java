package com.example.airline_reservation.Service;

import com.example.airline_reservation.Service.DTOs.PassengerDTO;

import java.util.List;

public interface PassengerService {

	public PassengerDTO addPassenger(PassengerDTO PassengerDTO);

	public PassengerDTO updatePassenger(PassengerDTO PassengerDTO);

	public void deletePassenger(int passengerId);

	public List<PassengerDTO> getPassengers();

	public PassengerDTO getPassengerById(int passengerId);
}

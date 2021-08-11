package com.example.airline_reservation.Service.DTOs;

import java.time.LocalDate;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

@Data
public class PassengerDTO extends PersonDTO {
	private LocalDate dob;

	public PassengerDTO() {
	}

	public PassengerDTO(int id, String firstName, String lastName, String email, Address address, String userName,
			LocalDate dob) {
		super(id, firstName, lastName, email, address, userName);
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Passenger [address=" + address + ", email=" + email + ", firstName=" + firstName + ", id=" + id
				+ ", lastName=" + lastName + ", userName=" + userName + ", dob=" + dob + "]";
	}
}
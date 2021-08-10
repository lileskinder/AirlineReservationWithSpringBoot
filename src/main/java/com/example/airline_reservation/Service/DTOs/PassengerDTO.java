package com.example.airline_reservation.Service.DTOs;

import java.time.LocalDate;

import javax.persistence.*;

import com.example.airline_reservation.Model.Address;
import com.example.airline_reservation.Model.Person;
import lombok.Data;

@Data
public class PassengerDTO extends PersonDTO {
	private LocalDate dob;

	public PassengerDTO() {
	}

	public PassengerDTO(String firstName, String lastName, String email, Address address, LocalDate dob) {
		super(firstName, lastName, email, address);
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "PassengerDTO{" +
				"dob=" + dob +
				", id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", address=" + address +
				'}';
	}
}
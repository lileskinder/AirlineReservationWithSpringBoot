package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

@Data
public class PersonDTO {
	private int id;
	private String firstName;
	private String lastName;
	private String email;

	private Address address;

	public PersonDTO() {
	}

	public PersonDTO(String firstName, String lastName, String email, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
	}

	public String toString() {
		return firstName + " " + lastName + " : " + email + " : " + address;
	}
}

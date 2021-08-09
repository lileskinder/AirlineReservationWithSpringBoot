package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

import javax.persistence.Embedded;

@Data
public class PersonDTO {
	private int id;
	private String firstName;
	private String lastName;
	private String email;

	private Address address;

	public PersonDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

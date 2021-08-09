package com.example.airline_reservation.Service.DTOs;

import java.time.LocalDate;

import javax.persistence.*;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

@Data
public class PersonDTO {
	private int id;

	private String firstName;
	private String lastName;

	private String email;
	private LocalDate dob;
	private int agentId;

	// Address
	@Embedded
	private Address address;

	public PersonDTO() {
	}

	public PersonDTO(String firstName, String lastName, String email, LocalDate dob, int agentId, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.agentId = agentId;
		this.address = address;
	}

	public PersonDTO(int id, String firstName, String lastName, String email, LocalDate dob, int agentId,
			Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.agentId = agentId;
		this.address = address;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
package com.example.airline_reservation.Service.DTOs;

import java.time.LocalDate;

import javax.persistence.*;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

@Data
public class PersonDTO {
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
}
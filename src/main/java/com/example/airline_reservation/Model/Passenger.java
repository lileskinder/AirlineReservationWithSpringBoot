package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
public class Passenger extends Person {

	@Column(name = "dob", nullable = false)
	private LocalDate dob;

	public Passenger() {
	}

	public Passenger(String firstName, String lastName, Address address, String email, LocalDate dob) {
		super(firstName, lastName, address, email);
		this.dob = dob;
	}

}

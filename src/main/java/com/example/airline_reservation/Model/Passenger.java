package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
public class Passenger extends Person {
	private LocalDate dob;

	public Passenger() {
	}

	public Passenger(String firstName, String lastName, Address address, String email, LocalDate dob) {
		super(firstName, lastName, address, email);
		this.dob = dob;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}

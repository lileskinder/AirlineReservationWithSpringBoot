package com.example.airline_reservation.Model;

import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
public class Admin extends Person {
	public Admin() {
	}

	public Admin(String firstName, String lastName, Address address, String email) {
		super(firstName, lastName, address, email);
	}

}

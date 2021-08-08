package com.example.airline_reservation.Model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public abstract class User {
	private int id;
	private String firstName;
	private String lastName;
	@Embedded
	private Address address;
	private String email;
}

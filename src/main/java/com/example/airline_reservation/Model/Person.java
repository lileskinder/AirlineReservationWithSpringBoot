package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
	@Id
	@GeneratedValue
	protected int id;
	@Column(name = "firstName", nullable = false)
	protected String firstName;
	@Column(name = "lastName", nullable = false)
	protected String lastName;
	protected Address address;
	protected String email;

	public Person() {
	}

	public Person(String firstName, String lastName, Address address, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
	}

}

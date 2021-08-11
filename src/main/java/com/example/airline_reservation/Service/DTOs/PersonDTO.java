package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

import javax.persistence.Column;

@Data
public class PersonDTO {
    protected int id;

    @Column(nullable = false)
    protected String firstName;

    @Column(nullable = false)
    protected String lastName;

    @Column(nullable = false)
    protected Address address;

    @Column(nullable = false, unique = true, updatable = false)
    protected String email;

    public PersonDTO() {}

    public PersonDTO(String firstName, String lastName, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

	@Override
	public String toString() {
		return "PersonDTO{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", address=" + address +
				'}';
	}
}

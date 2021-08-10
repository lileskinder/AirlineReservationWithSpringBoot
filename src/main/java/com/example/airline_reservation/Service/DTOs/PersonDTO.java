package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

@Data
public class PersonDTO {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;

    protected Address address;

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

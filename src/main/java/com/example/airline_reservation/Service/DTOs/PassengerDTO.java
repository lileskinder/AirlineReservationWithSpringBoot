package com.example.airline_reservation.Service.DTOs;

import java.time.LocalDate;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

@Data
public class PassengerDTO extends PersonDTO {
	protected LocalDate dob;
	private int roleId;
	private String password;
	private String roleName;

	public PassengerDTO() {
	}

	public PassengerDTO(int id, String firstName, String lastName, String email, Address address, String userName,
			LocalDate dob, int roleId, String password, String roleName) {
		super(id, firstName, lastName, email, address, userName);
		this.dob = dob;
		this.roleId = roleId;
		this.password = password;
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Passenger [address=" + address + ", email=" + email + ", firstName=" + firstName + ", id=" + id
				+ ", lastName=" + lastName + ", userName=" + userName + ", dob=" + dob + ", roleId=" + roleId
				+ ", password=" + password + ", roleName=" + roleName + "]";
	}
}
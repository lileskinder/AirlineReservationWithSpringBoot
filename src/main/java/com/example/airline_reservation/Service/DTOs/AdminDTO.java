package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

@Data
public class AdminDTO extends PersonDTO {

	public AdminDTO() {
	}

	public AdminDTO(int id, String firstName, String lastName, String email, Address address, String userName) {
		super(id, firstName, lastName, email, address, userName);
	}

}

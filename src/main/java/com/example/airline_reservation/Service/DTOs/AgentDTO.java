package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

import javax.persistence.Column;

@Data
public class AgentDTO extends PersonDTO {
	@Column(nullable = false, updatable = false, unique = true)
	private int agentId;

	public AgentDTO() {
	}

	public AgentDTO(int id, String firstName, String lastName, String email, Address address, String userName,
			int agentId) {
		super(id, firstName, lastName, email, address, userName);
		this.agentId = agentId;
	}

	@Override
	public String toString() {
		return "Agent [address=" + address + ", email=" + email + ", firstName=" + firstName + ", id=" + id
				+ ", lastName=" + lastName + ", userName=" + userName + ", agentId=" + agentId + "]";
	}
}

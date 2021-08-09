package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

@Data
public class AgentDTO extends PersonDTO {
	private int agentId;

	public AgentDTO() {
	}

	public AgentDTO(String firstName, String lastName, String email, Address address, int agentId) {
		super(firstName, lastName, email, address);
		this.agentId = agentId;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String toString() {
		return super.toString() + agentId;
	}
}

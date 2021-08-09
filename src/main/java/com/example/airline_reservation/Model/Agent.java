package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Agent extends Person {
	private int agentId;

	public Agent() {
	}

	public Agent(String firstName, String lastName, Address address, String email, int agentId) {
		super(firstName, lastName, address, email);
		this.agentId = agentId;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

}

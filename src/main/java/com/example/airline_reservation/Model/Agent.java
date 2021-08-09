package com.example.airline_reservation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("Agent")
public class Agent extends Person {
	private int agentId;

	public Agent() {
	}

	public Agent(String firstName, String lastName, Address address, String email, int agentId) {
		super(firstName, lastName, address, email);
		this.agentId = agentId;
	}

	@JsonIgnore
	@Override
	public String getType() {
		return "Agent";
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
}

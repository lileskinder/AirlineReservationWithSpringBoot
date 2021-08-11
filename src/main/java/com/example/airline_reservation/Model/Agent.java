package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.web.servlet.FlashMapManager;

@Data
@Entity
public class Agent extends Person {
	@Column(name = "agentId", nullable = false)
	private int agentId;

	public Agent() {
	}

	public Agent(String firstName, String lastName, Address address, String email, int agentId) {
		super(firstName, lastName, address, email);
		this.agentId = agentId;
	}
}

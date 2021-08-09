package com.example.airline_reservation.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue("AGENT")
public class Agent extends Person {
	private int agentId;
}

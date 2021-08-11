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

    public AgentDTO(String firstName, String lastName, String email, Address address, int agentId) {
        super(firstName, lastName, email, address);
        this.agentId = agentId;
    }

	@Override
	public String toString() {
		return "AgentDTO{" +
				"agentId=" + agentId +
				", id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", address=" + address +
				'}';
	}
}
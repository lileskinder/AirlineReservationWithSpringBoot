package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Agent extends Person {

    @Column(nullable = false, updatable = false, unique = true)
    private int agentId;

    public Agent() {
    }

    public Agent(int id, String firstName, String lastName, Address address, String email, String userName,
            int agentId) {
        super(id, firstName, lastName, address, email, userName);
        this.agentId = agentId;
    }

    @Override
    public String toString() {
        return "Agent [address=" + address + ", email=" + email + ", firstName=" + firstName + ", id=" + id
                + ", lastName=" + lastName + ", userName=" + userName + ", agentId=" + agentId + "]";
    }
}

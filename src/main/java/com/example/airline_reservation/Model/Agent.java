package com.example.airline_reservation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
public class Agent extends Person {

    @Column(nullable = false, updatable = false, unique = true)
    private int agentId;

    public Agent() {}

    public Agent(String firstName, String lastName, Address address, String email, int agentId) {
        super(firstName, lastName, address, email);
        this.agentId = agentId;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentId=" + agentId +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                '}';
    }
}

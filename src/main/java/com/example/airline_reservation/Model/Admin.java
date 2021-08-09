package com.example.airline_reservation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("Admin")
public class Admin extends Person {
    public Admin() { }

    public Admin(String firstName, String lastName, Address address, String email) {
        super(firstName, lastName, address, email);
    }

    @JsonIgnore
    @Override
    public String getType() {
        return "Admin";
    }
}

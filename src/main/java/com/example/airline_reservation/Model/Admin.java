package com.example.airline_reservation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
public class Admin extends Person {
    public Admin() { }

    public Admin(String firstName, String lastName, Address address, String email) {
        super(firstName, lastName, address, email);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                '}';
    }
}

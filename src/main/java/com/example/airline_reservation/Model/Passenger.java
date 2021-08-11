package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
public class Passenger extends Person {
    @Column(nullable = false)
    private LocalDate dob;

    public Passenger() {
    }

    public Passenger(int id, String firstName, String lastName, Address address, String email, String userName,
            LocalDate dob) {
        super(id, firstName, lastName, address, email, userName);
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Passenger [address=" + address + ", email=" + email + ", firstName=" + firstName + ", id=" + id
                + ", lastName=" + lastName + ", userName=" + userName + ", dob=" + dob + "]";
    }

}

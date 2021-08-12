package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
public class Passenger extends Person {
    @Column(nullable = false)
    private LocalDate dob;

    public Passenger() {}

    public Passenger(String firstName, String lastName, Address address, String email, LocalDate dob) {
        super(firstName, lastName, address, email);
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passenger)) return false;
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return dob.equals(passenger.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dob);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "dob=" + dob +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                '}';
    }
}

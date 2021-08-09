package com.example.airline_reservation.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
//@DiscriminatorValue("Passenger")
public class Passenger extends Person {
    private LocalDate dob;

    public Passenger() {}

    public Passenger(String firstName, String lastName, Address address, String email, LocalDate dob) {
        super(firstName, lastName, address, email);
        this.dob = dob;
    }

//    @JsonIgnore
//    @Override
//    public String getType() {
//        return "Passenger";
//    }
}

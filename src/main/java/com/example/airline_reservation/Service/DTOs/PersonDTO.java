package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Address;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Embedded;

@Data
public class PersonDTO {
//    @Setter(AccessLevel.NONE)
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;

    protected Address address;

    public PersonDTO() {}

    public PersonDTO(String firstName, String lastName, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

}

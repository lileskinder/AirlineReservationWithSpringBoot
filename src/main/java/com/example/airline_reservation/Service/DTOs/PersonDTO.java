package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

@Data
public class PersonDTO {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;

    protected Address address;
    protected String userName;

    public PersonDTO() {
    }

    public PersonDTO(int id, String firstName, String lastName, String email, Address address, String userName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "PersonDTO [address=" + address + ", email=" + email + ", firstName=" + firstName + ", id=" + id
                + ", lastName=" + lastName + ", userName=" + userName + "]";
    }

}

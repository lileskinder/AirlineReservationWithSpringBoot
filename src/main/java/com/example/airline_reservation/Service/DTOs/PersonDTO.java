package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

@Data
public class PersonDTO {
    protected int id;

    @Column(nullable = false)
    protected String firstName;

    @Column(nullable = false)
    protected String lastName;

    @Column(nullable = false)
    protected Address address;
    @Column(nullable = false)
    protected String userName;

    @Column(nullable = false, unique = true, updatable = false)
    protected String email;

    protected List<RoleDTO> roles;

    public PersonDTO() {
        roles = new ArrayList<>();
    }

    public PersonDTO(int id, String firstName, String lastName, String email, Address address, String userName,
            List<RoleDTO> roleDTOs) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.userName = userName;
        this.roles = roleDTOs;
    }

    @Override
    public String toString() {
        return "PersonDTO [address=" + address + ", email=" + email + ", firstName=" + firstName + ", id=" + id
                + ", lastName=" + lastName + ", userName=" + userName + "]";
    }

}

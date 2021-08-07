package com.example.airline_reservation.Model;

import lombok.Data;

@Data
public abstract class Person {
    private int id;
    private String firstName;
    private String lastName;
    private Address address;
    private String email;
}

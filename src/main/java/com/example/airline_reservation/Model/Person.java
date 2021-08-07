package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public abstract class Person {
    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;
    private Address address;
    private String email;
}

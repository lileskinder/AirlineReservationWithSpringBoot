package com.example.airline_reservation.Model;


import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address() {
    }

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }
}

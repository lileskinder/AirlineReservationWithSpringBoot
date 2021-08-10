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

    public Address(String sd, String dd, String aa, String dd1) {
    }

    public Address() {

    }
}

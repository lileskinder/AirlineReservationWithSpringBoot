package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Airport {

    @Id
    @GeneratedValue
    private int id;
    private String code;
    private String name;
    @Embedded
    private Address address;


    public Airport() {

    }

    public Airport(String code, String name, Address address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }

}

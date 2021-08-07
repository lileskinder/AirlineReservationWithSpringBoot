package com.example.airline_reservation.Model;

import lombok.Data;

@Data
public class Airport {
    private int id;
    private String code;
    private String name;
    private Address address;

}

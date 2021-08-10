package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Address;
import lombok.Data;

@Data
public class AirportDTO {
    private String code;
    private String name;
//    private String street;
//    private String city;
//    private String state;
//    private String zip;
    private Address address;
}

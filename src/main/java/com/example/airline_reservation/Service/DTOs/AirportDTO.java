package com.example.airline_reservation.Service.DTOs;

import com.example.airline_reservation.Model.Address;
import com.example.airline_reservation.Model.Airport;
import lombok.Data;

@Data
public class AirportDTO extends Airport {
    private String code;
    private String name;
    private Address address;
}

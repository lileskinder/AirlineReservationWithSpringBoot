package com.example.airline_reservation.Model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Airline {
    @Id @GeneratedValue
    private int id;
    private String code;
    private String name;
    private String history;

}

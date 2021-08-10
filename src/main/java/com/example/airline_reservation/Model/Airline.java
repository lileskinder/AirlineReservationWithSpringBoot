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

    public Airline() {
    }

    public Airline(int id, String code, String name, String history) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.history = history;
    }


}

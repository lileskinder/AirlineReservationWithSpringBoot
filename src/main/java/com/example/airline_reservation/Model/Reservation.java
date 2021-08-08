package com.example.airline_reservation.Model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Reservation {
    private int id;
    private String code;
    private User passenger;
    private List<Ticket> tickets = new ArrayList<>();
    private String status;

}

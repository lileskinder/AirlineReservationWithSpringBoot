package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ticket {

    @Id @GeneratedValue
    private int id;
    // must be 20 digit
    @Column(length = 20)
    private int number;
    private String reservationCode;

    @OneToOne
    private Person passenger;

    @ManyToOne @JoinColumn
    private Flight flight;
}

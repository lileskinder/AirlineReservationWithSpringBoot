package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ticket {

    @Id @GeneratedValue
    private int id;

    @Column(length = 20, nullable = false, updatable = false, unique = true)
    private int number;

    @OneToOne
    @JoinColumn(nullable = false, updatable = false)
    private Person passenger;

    @ManyToOne @JoinColumn(nullable = false, updatable = false)
    private Flight flight;
}

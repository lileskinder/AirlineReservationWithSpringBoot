package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
public class Ticket {

    @Id @GeneratedValue
    private int id;

    @Column(length = 20, nullable = false, updatable = false, unique = true)
    private BigInteger number;

    @OneToOne
    @JoinColumn(nullable = false, updatable = false)
    private Person passenger;

    @ManyToOne @JoinColumn(nullable = false, updatable = false)
    private Flight flight;

    @Column(nullable = false, updatable = false, length = 6)
    private String reservationCode;

    public Ticket() {
    }

    public Ticket(BigInteger number, Person passenger, Flight flight, String reservationCode) {
        this.number = number;
        this.passenger = passenger;
        this.flight = flight;
        this.reservationCode = reservationCode;
    }
}

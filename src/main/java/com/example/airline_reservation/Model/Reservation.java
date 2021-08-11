package com.example.airline_reservation.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Reservation {
    @Id @GeneratedValue
    private int id;

    @Column(nullable = false, updatable = false, unique = true)
    private String code;

    @OneToOne
    @JoinColumn(nullable = false, updatable = false)
    private Person customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="reservation_id", nullable = false)
    private List<Ticket> tickets = new ArrayList<>();

    @Column(nullable = false)
    private ReservationStatus status;

}

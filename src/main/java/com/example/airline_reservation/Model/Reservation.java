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
    private String code;

    @OneToOne
    private Person customer;

    @OneToMany(cascade = CascadeType.ALL) @JoinColumn(name="reservation_id")
    private List<Ticket> tickets = new ArrayList<>();
    private ReservationStatus status;

}

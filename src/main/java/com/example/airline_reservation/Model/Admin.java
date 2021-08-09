package com.example.airline_reservation.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
@DiscriminatorValue("ADMIN")
public class Admin extends Person {
}

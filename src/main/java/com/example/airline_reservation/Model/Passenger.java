package com.example.airline_reservation.Model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
@DiscriminatorValue("PASSENGER")
public class Passenger extends Person {
	private LocalDate dob;
}

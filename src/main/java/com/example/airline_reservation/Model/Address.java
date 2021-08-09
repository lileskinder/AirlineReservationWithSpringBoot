package com.example.airline_reservation.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Address {
	@Id
	@GeneratedValue
	private int Id;
	private String street;
	private String city;
	private String state;
	private String zip;
}

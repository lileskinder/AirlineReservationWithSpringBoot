package com.example.airline_reservation.Web.DTOs;

import java.time.LocalDate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
public class PersonDTO {
	private int id;
	private String firstName;
	private String lastName;
	private int addressId;
	private String email;
	private LocalDate dob;
	private int agentId;
}
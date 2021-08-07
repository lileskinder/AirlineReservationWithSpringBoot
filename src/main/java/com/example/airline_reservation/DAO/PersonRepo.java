package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Integer> {
}

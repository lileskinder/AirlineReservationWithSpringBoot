package com.example.airline_reservation.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airline_reservation.Model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
}
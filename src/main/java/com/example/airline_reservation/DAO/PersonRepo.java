package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PersonRepo extends JpaRepository<Person, Integer> {
}

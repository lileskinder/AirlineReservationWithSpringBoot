package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository @Transactional
public interface PersonRepo extends JpaRepository<Person, Integer> {
    Optional<Person> getPersonByUserName(String userName);
}

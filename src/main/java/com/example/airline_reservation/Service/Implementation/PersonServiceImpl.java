package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.PersonRepo;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepo personRepo;

    public Person addPerson(Person person) {
        return personRepo.save(person);
    }
}

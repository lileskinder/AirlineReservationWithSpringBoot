package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.Model.Passenger;
import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Model.Role;
import com.example.airline_reservation.Service.DTOs.PersonDTO;

public class PersonDTOAdapter {

    public static Person getPerson(PersonDTO personDTO) {
        Person person = new Passenger();
        if (personDTO != null) {
            person.setId(personDTO.getId());
            person.setFirstName(personDTO.getFirstName());
            person.setLastName(personDTO.getLastName());
            person.setEmail(personDTO.getEmail());
            person.setAddress(personDTO.getAddress());
            person.setUserName(personDTO.getUserName());
        }

        return person;
    }

    public static PersonDTO getPersonDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();

        if (person != null) {
            personDTO.setId(person.getId());
            personDTO.setFirstName(person.getFirstName());
            personDTO.setLastName(person.getLastName());
            personDTO.setEmail(person.getEmail());
            personDTO.setAddress(person.getAddress());
            personDTO.setUserName(person.getUserName());

        }
        return personDTO;
    }
}

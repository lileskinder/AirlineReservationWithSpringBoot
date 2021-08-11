package com.example.airline_reservation.Model;

import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
public class Admin extends Person {
    public Admin() {
    }

    public Admin(int id, String firstName, String lastName, Address address, String email, String userName) {
        super(id, firstName, lastName, address, email, userName);
    }

}

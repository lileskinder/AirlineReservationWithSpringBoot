package com.example.airline_reservation.Model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Id
    @GeneratedValue
    protected int id;
    @Column(name = "firstName", nullable = false)
    protected String firstName;
    @Column(name = "lastName", nullable = false)
    protected String lastName;
    protected Address address;
    protected String email;

    @Column(name = "userName", nullable = false)
    protected String userName;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, Address address, String email, String userName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Person [address=" + address + ", email=" + email + ", firstName=" + firstName + ", id=" + id
                + ", lastName=" + lastName + ", userName=" + userName + "]";
    }
}

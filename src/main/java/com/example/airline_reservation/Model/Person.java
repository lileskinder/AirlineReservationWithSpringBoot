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

    @Column(nullable = false)
    protected String firstName;

    @Column(nullable = false)
    protected String lastName;

    @Column(nullable = false)
    protected Address address;

    @Column(nullable = false, unique = true, updatable = false)
    protected String email;

    @Column(nullable = false, unique = true)
    protected String userName;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn
    // protected List<Role> roles = new ArrayList<>();

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

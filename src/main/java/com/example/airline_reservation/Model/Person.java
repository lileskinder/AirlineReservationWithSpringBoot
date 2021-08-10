package com.example.airline_reservation.Model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
//@JsonSubTypes(
//        {
//                @JsonSubTypes.Type(value = Passenger.class, name = "passenger"),
//                @JsonSubTypes.Type(value = Agent.class, name = "agent"),
//                @JsonSubTypes.Type(value = Admin.class, name = "admin")
//        })
public abstract class Person {
    @Id
    @GeneratedValue
    protected int id;

    protected String firstName;
    protected String lastName;
    protected Address address;
    protected String email;

    public Person() {}

    public Person(String firstName, String lastName, Address address, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }

//    public abstract String getType();


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                '}';
    }
}

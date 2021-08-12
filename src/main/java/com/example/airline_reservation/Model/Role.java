package com.example.airline_reservation.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue
    protected int id;

    @Column(name = "role", updatable = false, nullable = false)
    protected String role;

    @Column(name = "password", updatable = false, nullable = false)
    protected String username;

    @Column(name = "password", insertable = false, updatable = false, nullable = false)
    protected String password;

    public Role() {
    }

    public Role(String role, String username, String password) {
        this.role = role;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
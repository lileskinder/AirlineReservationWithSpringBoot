package com.example.airline_reservation.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue
    protected int id;
    @Column(name = "role", nullable = false, updatable = false)
    protected String role;
    @Column(name = "userName", nullable = false, updatable = false)
    protected String userName;
    @Column(name = "password", nullable = false, updatable = false)
    protected String password;

    public Role(int id, String role, String userName, String password) {
        this.id = id;
        this.role = role;
        this.userName = userName;
        this.password = password;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", role=" + role + ", username=" + userName + "]";
    }
}

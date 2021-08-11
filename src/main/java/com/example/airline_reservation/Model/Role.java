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
    @Column(name = "role", nullable = false)
    protected String role;
    @Column(name = "password", nullable = false)
    protected String password;

    protected int personId;

    public Role(int id, String role, String password, int personId) {
        this.id = id;
        this.role = role;
        this.password = password;
        this.personId = personId;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", role=" + role + ", password=*****, personId=" + personId + "]";
    }
}

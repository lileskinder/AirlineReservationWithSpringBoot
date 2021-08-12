package com.example.airline_reservation.Service.DTOs;

import lombok.Data;

@Data
public class RoleDTO {
    protected int id;
    protected String role;
    protected String username;
    protected String password;

    public RoleDTO() {
    }

    public RoleDTO(int id, String role, String username, String password) {
        this.id = id;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
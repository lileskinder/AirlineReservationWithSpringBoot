package com.example.airline_reservation.Service.DTOs;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RoleDTO {
    protected int id;
    protected String role;
    protected String userName;
    protected String password;

    public RoleDTO() {
    }

    public RoleDTO(int id, String role, String userName, String password, PersonDTO personDTO) {
        this.id = id;
        this.role = role;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "RoleDTO [id=" + id + ", role=" + role + ", username=" + userName + ", password=" + password + "]";
    }

}
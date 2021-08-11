package com.example.airline_reservation.Service.DTOs;

import lombok.Data;

@Data
public class RoleDTO {
    protected int id;
    protected String role;
    protected String password;
    protected int personId;

    public RoleDTO() {
    }

    public RoleDTO(int id, String role, String password, int personId) {
        this.id = id;
        this.role = role;
        this.password = password;
        this.personId = personId;
    }

    @Override
    public String toString() {
        return "RoleDTO [id=" + id + ", role=" + role + ", password=" + password + ", personId=" + personId + "]";
    }

}
package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.Model.Role;
import com.example.airline_reservation.Service.DTOs.RoleDTO;

public class RoleDTOAdapter {

    public static Role getRole(RoleDTO roleDTO) {
        Role role = new Role();
        if (roleDTO != null) {
            role.setId(roleDTO.getId());
            role.setRole(roleDTO.getRole());
            role.setPassword(roleDTO.getPassword());
            role.setPersonId(roleDTO.getPersonId());
        }

        return role;
    }

    public static RoleDTO getRoleDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();

        if (role != null) {
            roleDTO.setId(role.getId());
            roleDTO.setRole(role.getRole());
            roleDTO.setPassword(role.getPassword());
            roleDTO.setPersonId(role.getPersonId());
        }
        return roleDTO;
    }
}

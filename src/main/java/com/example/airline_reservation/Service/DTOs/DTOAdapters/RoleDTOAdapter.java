package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.Model.Person;
import com.example.airline_reservation.Model.Role;
import com.example.airline_reservation.Service.DTOs.PersonDTO;
import com.example.airline_reservation.Service.DTOs.RoleDTO;

import org.springframework.security.access.method.P;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class RoleDTOAdapter {

    public static Role getRole(RoleDTO roleDTO) {
        Role role = new Role();
        if (roleDTO != null) {
            role.setId(roleDTO.getId());
            role.setRole(roleDTO.getRole());
            role.setUserName(roleDTO.getUserName());
            role.setPassword(hash(roleDTO.getPassword()));
        }

        return role;
    }

    public static RoleDTO getRoleDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();

        if (role != null) {
            roleDTO.setId(role.getId());
            roleDTO.setRole(role.getRole());
            roleDTO.setUserName(role.getUserName());
            roleDTO.setPassword(role.getPassword());
        }
        return roleDTO;
    }

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(11));
    }
}

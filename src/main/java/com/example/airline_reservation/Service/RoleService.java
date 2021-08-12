package com.example.airline_reservation.Service;

import com.example.airline_reservation.Service.DTOs.RoleDTO;

import java.util.List;

public interface RoleService {
    RoleDTO addRole(RoleDTO RoleDTO);

    RoleDTO updateRole(RoleDTO RoleDTO);

    void deleteRole(int RoleId);

    List<RoleDTO> getRoles();

    RoleDTO getRoleById(int RoleId);
}

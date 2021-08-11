package com.example.airline_reservation.Service;

import com.example.airline_reservation.Service.DTOs.RoleDTO;

import java.util.List;

public interface RoleService {
    public RoleDTO addRole(RoleDTO RoleDTO);

    public RoleDTO updateRole(RoleDTO RoleDTO);

    public void deleteRole(int RoleId);

    public List<RoleDTO> getRoles();

    public RoleDTO getRoleById(int RoleId);
}

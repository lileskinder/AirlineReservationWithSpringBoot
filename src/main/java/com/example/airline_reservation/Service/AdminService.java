package com.example.airline_reservation.Service;

import com.example.airline_reservation.Service.DTOs.AdminDTO;
import com.example.airline_reservation.Service.DTOs.RoleDTO;

import java.util.List;

public interface AdminService {

    public AdminDTO addAdmin(AdminDTO Admin);

    public AdminDTO updateAdmin(AdminDTO AdminDTO);

    public void deleteAdmin(int AdminId);

    public List<AdminDTO> getAdmins();

    public AdminDTO getAdminById(int AdminId);

    public List<RoleDTO> getAdminRoles(int adminId);
}

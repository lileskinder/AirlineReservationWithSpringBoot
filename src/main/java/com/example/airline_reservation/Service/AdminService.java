package com.example.airline_reservation.Service;

import java.util.List;

import com.example.airline_reservation.Service.DTOs.AdminDTO;

public interface AdminService {

	public AdminDTO addAdmin(AdminDTO Admin);

	public AdminDTO updateAdmin(AdminDTO AdminDTO);

	public void deleteAdmin(int AdminId);

	public List<AdminDTO> getAdmins();

	public AdminDTO getAdminById(int AdminId);
}

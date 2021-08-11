package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.Model.Admin;
import com.example.airline_reservation.Service.DTOs.AdminDTO;

public class AdminDTOAdapter {

	public static AdminDTO getAdminDTO(Admin admin) {
		AdminDTO adminDTO = new AdminDTO();
		if (admin != null) {
			adminDTO.setId(admin.getId());
			adminDTO.setFirstName(admin.getFirstName());
			adminDTO.setLastName(admin.getLastName());
			adminDTO.setEmail(admin.getEmail());
			adminDTO.setAddress(admin.getAddress());

			adminDTO.setUserName(admin.getUserName());
		}
		return adminDTO;
	}

	public static Admin getAdmin(AdminDTO adminDTO) {
		Admin admin = new Admin();
		if (adminDTO != null) {
			admin.setId(adminDTO.getId());
			admin.setFirstName(adminDTO.getFirstName());
			admin.setLastName(adminDTO.getLastName());
			admin.setEmail(adminDTO.getEmail());
			admin.setAddress(adminDTO.getAddress());

			admin.setUserName(adminDTO.getUserName());
		}
		return admin;
	}
}

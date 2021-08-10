package com.example.airline_reservation.Service.Implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.airline_reservation.DAO.AdminRepo;
import com.example.airline_reservation.Model.Admin;
import com.example.airline_reservation.Service.AdminService;
import com.example.airline_reservation.Service.DTOs.AdminDTO;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.AdminDTOAdapter;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepo repo;

	@Override
	public AdminDTO addAdmin(AdminDTO adminDTO) {
		Admin admin = AdminDTOAdapter.getAdmin(adminDTO);
		return AdminDTOAdapter.getAdminDTO(repo.save(admin));

	}

	@Override
	public AdminDTO updateAdmin(AdminDTO adminDTO) {
		Admin admin = AdminDTOAdapter.getAdmin(adminDTO);
		return AdminDTOAdapter.getAdminDTO(repo.save(admin));
	}

	@Override
	public void deleteAdmin(int adminId) {
		if (!repo.existsById(adminId)) {
			throw new IllegalStateException("Admin with id " + adminId + " does not exists");
		}
		repo.deleteById(adminId);
	}

	@Override
	public List<AdminDTO> getAdmins() {
		List<Admin> admins = repo.findAll();
		List<AdminDTO> adminDTOList = new ArrayList<>();

		for (Admin admin : admins) {
			adminDTOList.add(AdminDTOAdapter.getAdminDTO(admin));
		}

		return adminDTOList;
	}

	@Override
	public AdminDTO getAdminById(int adminId) {
		Admin admin = repo.findById(adminId)
				.orElseThrow(() -> new IllegalStateException("Admin with id " + adminId + " does not exists"));
		return AdminDTOAdapter.getAdminDTO(admin);
	}
}

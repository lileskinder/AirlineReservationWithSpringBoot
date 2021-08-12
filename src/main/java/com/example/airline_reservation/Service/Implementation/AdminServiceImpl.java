package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.AdminRepo;
import com.example.airline_reservation.ExceptionHandling.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.airline_reservation.Model.Admin;
import com.example.airline_reservation.Model.Role;
import com.example.airline_reservation.Service.AdminService;
import com.example.airline_reservation.Service.DTOs.AdminDTO;
import com.example.airline_reservation.Service.DTOs.RoleDTO;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.AdminDTOAdapter;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.RoleDTOAdapter;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	private final String NOT_FOUND_ADMIN = " admin does not exists";
	private final AdminRepo repo;

	@Autowired
	public AdminServiceImpl(AdminRepo repo) {
		this.repo = repo;
	}

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
			throw new ResourceNotFoundException(adminId + NOT_FOUND_ADMIN);
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
				.orElseThrow(() -> new ResourceNotFoundException(adminId + NOT_FOUND_ADMIN));
		return AdminDTOAdapter.getAdminDTO(admin);
	}

	@Override
	public List<RoleDTO> getAdminRoles(int adminId) {

		Admin admin = repo.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException(adminId + NOT_FOUND_ADMIN));

		List<Role> roles = admin.getRoles();
		List<RoleDTO> roleDTOList = new ArrayList<>();

		for (Role role : roles) {
			roleDTOList.add(RoleDTOAdapter.getRoleDTO(role));
		}

		return roleDTOList;
	}
}

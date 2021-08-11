package com.example.airline_reservation.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airline_reservation.Service.AdminService;
import com.example.airline_reservation.Service.DTOs.AdminDTO;

@RestController
@RequestMapping("/admins")
public class AdminController {

	private final AdminService service;

	public AdminController(AdminService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<AdminDTO>> getAdmins() {
		return new ResponseEntity<List<AdminDTO>>(service.getAdmins(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AdminDTO> getAdminById(@PathVariable(name = "id") int id) {
		return new ResponseEntity<AdminDTO>(service.getAdminById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<AdminDTO> addAdmin(@RequestBody AdminDTO AdminDTO) {
		return new ResponseEntity<AdminDTO>(service.addAdmin(AdminDTO), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<AdminDTO> updateAdmin(@RequestBody AdminDTO AdminDTO) {
		return new ResponseEntity<AdminDTO>(service.updateAdmin(AdminDTO), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<AdminDTO> deleteAdmin(@RequestBody AdminDTO AdminDTO) {
		service.deleteAdmin(AdminDTO.getId());
		return new ResponseEntity(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<AdminDTO> deleteAdminById(@PathVariable(name = "id") int id) {
		service.deleteAdmin(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}

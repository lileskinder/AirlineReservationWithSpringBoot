package com.example.airline_reservation.Web;

import com.example.airline_reservation.Service.AdminService;
import com.example.airline_reservation.Service.DTOs.AdminDTO;
import com.example.airline_reservation.Service.DTOs.RoleDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> getAdmins() {
        return new ResponseEntity<>(service.getAdmins(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> getAdminById(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(service.getAdminById(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> addAdmin(@Valid @RequestBody AdminDTO AdminDTO) {
        return new ResponseEntity<>(service.addAdmin(AdminDTO), HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> updateAdmin(@Valid @RequestBody AdminDTO AdminDTO) {
        return new ResponseEntity<>(service.updateAdmin(AdminDTO), HttpStatus.OK);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> deleteAdmin(@Valid @RequestBody AdminDTO AdminDTO) {
        service.deleteAdmin(AdminDTO.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> deleteAdminById(@PathVariable(name = "id") int id) {
        service.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/roles")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> getAdminRoles(@PathVariable(name = "id") int id) {
        List<RoleDTO> roles = service.getAdminRoles(id);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}

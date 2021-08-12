package com.example.airline_reservation.Web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airline_reservation.Service.RoleService;
import com.example.airline_reservation.Service.DTOs.RoleDTO;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<List<RoleDTO>> getRoles() {
        return new ResponseEntity<>(service.getRoles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(service.getRoleById(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<RoleDTO> addRole(@RequestBody RoleDTO RoleDTO) {
        return new ResponseEntity<>(service.addRole(RoleDTO), HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<RoleDTO> updateRole(@RequestBody RoleDTO RoleDTO) {
        return new ResponseEntity<>(service.updateRole(RoleDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<RoleDTO> deleteRole(@RequestBody RoleDTO RoleDTO) {
        service.deleteRole(RoleDTO.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<RoleDTO> deleteRoleById(@PathVariable(name = "id") int id) {
        service.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

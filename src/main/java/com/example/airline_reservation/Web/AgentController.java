package com.example.airline_reservation.Web;

import com.example.airline_reservation.Service.AgentService;
import com.example.airline_reservation.Service.DTOs.AgentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/agents")
public class AgentController {

    private final AgentService service;

    @Autowired
    public AgentController(AgentService service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<?> getAgents() {
        return new ResponseEntity<>(service.getAgents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'AGENT', 'PASSENGER')")
    public ResponseEntity<?> getAgentById(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(service.getAgentById(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> addAgent(@Valid @RequestBody AgentDTO AgentDTO) {
        return new ResponseEntity<>(service.addAgent(AgentDTO), HttpStatus.OK);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> updateAgent(@Valid @RequestBody AgentDTO AgentDTO) {
        return new ResponseEntity<>(service.updateAgent(AgentDTO), HttpStatus.OK);
    }

    @DeleteMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> deleteAgent(@Valid @RequestBody AgentDTO AgentDTO) {
        service.deleteAgent(AgentDTO.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> deleteAgentById(@PathVariable(name = "id") int id) {
        service.deleteAgent(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

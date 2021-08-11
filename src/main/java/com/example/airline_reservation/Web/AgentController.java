package com.example.airline_reservation.Web;

import com.example.airline_reservation.Service.AgentService;
import com.example.airline_reservation.Service.DTOs.AgentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController {

    private final AgentService service;

    @Autowired
    public AgentController(AgentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAgents() {
        return new ResponseEntity<>(service.getAgents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAgentById(@PathVariable(name = "id") int id) {
        return new ResponseEntity<>(service.getAgentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addAgent(@Valid @RequestBody AgentDTO AgentDTO) {
        return new ResponseEntity<>(service.addAgent(AgentDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateAgent(@Valid @RequestBody AgentDTO AgentDTO) {
        return new ResponseEntity<>(service.updateAgent(AgentDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAgent(@Valid @RequestBody AgentDTO AgentDTO) {
        service.deleteAgent(AgentDTO.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAgentById(@PathVariable(name = "id") int id) {
        service.deleteAgent(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

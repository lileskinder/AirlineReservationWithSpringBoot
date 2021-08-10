package com.example.airline_reservation.Web;

import com.example.airline_reservation.Service.AgentService;
import com.example.airline_reservation.Service.DTOs.AgentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<AgentDTO>> getAgents() {
        return new ResponseEntity<List<AgentDTO>>(service.getAgents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgentDTO> getAgentById(@PathVariable(name = "id") int id) {
        return new ResponseEntity<AgentDTO>(service.getAgentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AgentDTO> addAgent(@RequestBody AgentDTO AgentDTO) {
        return new ResponseEntity<AgentDTO>(service.addAgent(AgentDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AgentDTO> updateAgent(@RequestBody AgentDTO AgentDTO) {
        return new ResponseEntity<AgentDTO>(service.updateAgent(AgentDTO), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<AgentDTO> deleteAgent(@RequestBody AgentDTO AgentDTO) {
        service.deleteAgent(AgentDTO.getId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AgentDTO> deleteAgentById(@PathVariable(name = "id") int id) {
        service.deleteAgent(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

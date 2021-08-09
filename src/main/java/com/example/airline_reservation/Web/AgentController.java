package com.example.airline_reservation.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.airline_reservation.Service.AgentService;
import com.example.airline_reservation.Service.DTOs.AgentDTO;

@RestController
@RequestMapping("/agents")
public class AgentController {

	@Autowired
	AgentService service;

	@GetMapping
	public ResponseEntity<List<AgentDTO>> getAgents() {
		return new ResponseEntity<List<AgentDTO>>(service.getAgents(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<AgentDTO> addAgent(@RequestBody AgentDTO AgentDTO) {
		return new ResponseEntity<AgentDTO>(service.addAgent(AgentDTO), HttpStatus.OK);
	}

	@PostMapping("/update")
	public ResponseEntity<AgentDTO> updateAgent(@RequestBody AgentDTO AgentDTO) {
		return new ResponseEntity<AgentDTO>(service.updateAgent(AgentDTO), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AgentDTO> getAgentById(@PathVariable(name = "id") int id) {
		return new ResponseEntity<AgentDTO>(service.getAgentById(id), HttpStatus.OK);
	}

	@PostMapping("/delete")
	public ResponseEntity<AgentDTO> deleteAgent(@RequestBody AgentDTO AgentDTO) {
		service.deleteAgent(AgentDTO.getId());
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/{id}/delete")
	public ResponseEntity<AgentDTO> deleteAgent(@PathVariable(name = "id") int id) {
		service.deleteAgent(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}

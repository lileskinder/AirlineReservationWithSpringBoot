package com.example.airline_reservation.Service;

import java.util.List;

import com.example.airline_reservation.Service.DTOs.AgentDTO;

public interface AgentService {

	public AgentDTO addAgent(AgentDTO agent);

	public AgentDTO updateAgent(AgentDTO AgentDTO);

	public void deleteAgent(int agentId);

	public List<AgentDTO> getAgents();

	public AgentDTO getAgentById(int agentId);
}

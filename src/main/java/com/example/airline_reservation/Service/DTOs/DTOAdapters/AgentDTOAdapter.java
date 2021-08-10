package com.example.airline_reservation.Service.DTOs.DTOAdapters;

import com.example.airline_reservation.Model.Agent;
import com.example.airline_reservation.Service.DTOs.AgentDTO;

public class AgentDTOAdapter {

	public static AgentDTO getAgentDTO(Agent agent) {
		AgentDTO agentDTO = new AgentDTO();
		if (agent != null) {
			agentDTO.setId(agent.getId());
			agentDTO.setFirstName(agent.getFirstName());
			agentDTO.setLastName(agent.getLastName());
			agentDTO.setEmail(agent.getEmail());
			agentDTO.setAddress(agent.getAddress());

			agentDTO.setAgentId(agent.getAgentId());
		}
		return agentDTO;
	}

	public static Agent getAgent(AgentDTO agentDTO) {
		Agent agent = new Agent();
		if (agent != null) {
			agent.setId(agentDTO.getId());
			agent.setFirstName(agentDTO.getFirstName());
			agent.setLastName(agentDTO.getLastName());
			agent.setEmail(agentDTO.getEmail());
			agent.setAddress(agentDTO.getAddress());
			agent.setAgentId(agentDTO.getAgentId());
		}
		return agent;
	}
}

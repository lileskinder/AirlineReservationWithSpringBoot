package com.example.airline_reservation.Service.Implementation;

import com.example.airline_reservation.DAO.AgentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javassist.NotFoundException;

import com.example.airline_reservation.DAO.AgentRepo;
import com.example.airline_reservation.Model.Agent;
import com.example.airline_reservation.Service.AgentService;
import com.example.airline_reservation.Service.DTOs.AgentDTO;
import com.example.airline_reservation.Service.DTOs.DTOAdapters.AgentDTOAdapter;

@Service
@Transactional
public class AgentServiceImpl implements AgentService {

	@Autowired
	AgentRepo repo;

	@Override
	public AgentDTO addAgent(AgentDTO AgentDTO) {
		Agent agent = AgentDTOAdapter.getAgent(AgentDTO);
		return AgentDTOAdapter.getAgentDTO(repo.save(agent));

	}

	@Override
	public AgentDTO updateAgent(AgentDTO AgentDTO) {
		Agent agent = AgentDTOAdapter.getAgent(AgentDTO);
		return AgentDTOAdapter.getAgentDTO(repo.save(agent));
	}

	@Override
	public void deleteAgent(int agentId) {
		if (existsAgent(agentId))
			repo.deleteById(agentId);
	}

	@Override
	public List<AgentDTO> getAgents() {
		List<Agent> agents = repo.findAll();
		List<AgentDTO> AgentDTOList = new ArrayList<>();

		for (Agent agent : agents) {
			AgentDTOList.add(AgentDTOAdapter.getAgentDTO(agent));
		}

		return AgentDTOList;
	}

	@Override
	public AgentDTO getAgentById(int agentId) {
		Agent agent = null;
		agent = repo.findById(agentId)
				.orElseThrow(() -> new IllegalStateException("Agent with id " + agentId + " does not exists"));

		return AgentDTOAdapter.getAgentDTO(agent);
	}

	private boolean existsAgent(int agentId) {
		if (!repo.existsById(agentId)) {
			throw new IllegalStateException("Agent with id " + agentId + " does not exists");
		} else {
			return true;
		}
	}

}

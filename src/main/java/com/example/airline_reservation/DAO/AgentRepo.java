package com.example.airline_reservation.DAO;

import com.example.airline_reservation.Model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepo extends JpaRepository<Agent, Integer> {
}

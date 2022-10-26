package com.monocept.insuranceapp.dao;

import java.util.List;

import com.monocept.insuranceapp.entity.Agent;

public interface AgentDao {
	Agent getAgent(int agentId);
	List<Agent> getAgents();
	Agent addAgent(Agent agent);
	Agent updateAgent(Agent agent);
	Agent deleteAgent(int agentId);
}

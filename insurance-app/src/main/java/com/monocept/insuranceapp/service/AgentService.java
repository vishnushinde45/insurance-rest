package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.Agent;

public interface AgentService {
	Agent getAgent(int agentId);
	List<Agent> getAgents();
	Agent addAgent(Agent agent);
	Agent updateAgent(Agent agent);
	Agent deleteAgent(int agentId);
	Agent login(Agent agent);
}

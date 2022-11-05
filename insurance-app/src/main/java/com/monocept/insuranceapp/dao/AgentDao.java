package com.monocept.insuranceapp.dao;

import java.util.List;

import com.monocept.insuranceapp.entity.Agent;
import com.monocept.insuranceapp.utility.ChangePassword;
import com.monocept.insuranceapp.utility.WithdrawAmount;

public interface AgentDao {
	Agent getAgent(int agentId);
	List<Agent> getAgents();
	Agent addAgent(Agent agent);
	Agent updateAgent(Agent agent);
	Agent deleteAgent(int agentId);
	Agent login(Agent agent);
	void changePassword(ChangePassword passwordBody, int agentId);
	void withdrawAmount(int agentId, int withdrawAmount);
}

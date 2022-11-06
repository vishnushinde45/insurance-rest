package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.Agent;
import com.monocept.insuranceapp.entity.InstallmentPayments;
import com.monocept.insuranceapp.utility.ChangePassword;
import com.monocept.insuranceapp.utility.Mail;
import com.monocept.insuranceapp.utility.WithdrawCommision;

public interface AgentService {
	Agent getAgent(int agentId);
	List<Agent> getAgents();
	Agent addAgent(Agent agent);
	Agent updateAgent(Agent agent);
	Agent deleteAgent(int agentId);
	Agent login(Agent agent);
	void sendMail(Mail mailBody);
	void changePassword(ChangePassword passwordBody, int agentId);
	List<InstallmentPayments> getInstallmentPayments();
	void withdrawAmount(WithdrawCommision withdrawBody, int agentId);
}

package com.monocept.insuranceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monocept.insuranceapp.dao.AgentDao;
import com.monocept.insuranceapp.entity.Agent;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentDao agentDao;

	@Override
	@Transactional
	public Agent getAgent(int agentId) {
		return agentDao.getAgent(agentId);
	}

	@Override
	@Transactional
	public List<Agent> getAgents() {
		return agentDao.getAgents();
	}

	@Override
	@Transactional
	public Agent addAgent(Agent agent) {
		return agentDao.addAgent(agent);
	}

	@Override
	@Transactional
	public Agent updateAgent(Agent agent) {
		return agentDao.updateAgent(agent);
	}

	@Override
	@Transactional
	public Agent deleteAgent(int agentId) {
		return agentDao.deleteAgent(agentId);
	}

	@Override
	@Transactional
	public Agent login(Agent agent) {
		// TODO Auto-generated method stub
		return agentDao.login(agent);
	}

}

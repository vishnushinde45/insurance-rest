package com.monocept.insuranceapp.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.insuranceapp.entity.Agent;

@Repository
public class AgentDaoImpl implements AgentDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public Agent getAgent(int agentId) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Agent.class, agentId);
	}

	@Override
	public List<Agent> getAgents() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from Agent").getResultList();
	}

	@Override
	public Agent addAgent(Agent agent) {
		agent.setPassword(this.generatePassword());
		Session session = entityManager.unwrap(Session.class);
		boolean isAlreadyExist=this.checkUserIsAlreadyExist(agent);
		if(isAlreadyExist) {
			throw new RuntimeException("Agent is already Exists");
		}else {
			session.saveOrUpdate(agent);
			agent.setAgentCode("AG"+agent.getId());
			
		}
		
		return agent;
	}

	@Override
	public Agent updateAgent(Agent agent) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(agent);
		return agent;
	}

	@Override
	public Agent deleteAgent(int agentId) {
		Session session = entityManager.unwrap(Session.class);
		Agent agent = session.get(Agent.class, agentId);
		session.delete(agent);
		return agent;

	}
	public boolean checkUserIsAlreadyExist(Agent agent) {
		List<Agent> agents = this.getAgents();
		return agents.stream().anyMatch(cust->cust.getUsername().equalsIgnoreCase(agent.getUsername()));
		 
	}
	
	public String generatePassword() {
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}

}

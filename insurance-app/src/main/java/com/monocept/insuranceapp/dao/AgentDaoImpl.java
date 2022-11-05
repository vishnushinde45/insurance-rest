package com.monocept.insuranceapp.dao;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.insuranceapp.email.EmailSenderService;
import com.monocept.insuranceapp.entity.Admin;
import com.monocept.insuranceapp.entity.Agent;
import com.monocept.insuranceapp.entity.Transactions;
import com.monocept.insuranceapp.utility.ChangePassword;
import com.monocept.insuranceapp.utility.WithdrawAmount;

@Repository
public class AgentDaoImpl implements AgentDao {

	@Autowired
	EntityManager entityManager;
	
	@Autowired
	private EmailSenderService senderService;

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
			String mail=agent.getEmailId();
			String subject="Successfull Registration on Sun Insurance System!";
			String body="You are Registered Successfully, Your Username is: "+agent.getUsername()+" and password is : "+agent.getPassword();
			senderService.sendEmail(mail, subject, body);
			
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

	@Override
	public Agent login(Agent agent) {
		Session session = entityManager.unwrap(Session.class);
		boolean isAuthenticated=authenticate(agent);
		Agent result=null;
		if(isAuthenticated)
			result=this.getByUsername(agent.getUsername());
		else
			throw new RuntimeException("Invalid Agent Details");
		
		return result;
	}
	
	private Agent getByUsername(String username) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Agent where username=:userName");
		query.setParameter("userName", username);
		List resultList = query.getResultList();
		if(resultList!=null)
			return (Agent) resultList.get(0);
		return null;
	}

	private boolean authenticate(Agent agent) {
		Agent ag=this.getByUsername(agent.getUsername());
		if(agent.getUsername().equals(ag.getUsername()) && agent.getPassword().equals(ag.getPassword()))
			return true;
		if(ag==null)
			return false;
		return false;
	}

	@Override
	public void changePassword(ChangePassword passwordBody, int agentId){
		 Session session = entityManager.unwrap(Session.class);
		 Agent agent = session.get(Agent.class, agentId);
		 
		 if(agent.getPassword().equals(passwordBody.getOldPassword())) {
			 agent.setPassword(passwordBody.getNewPassword());
			 session.saveOrUpdate(agent);
		 }
		 else {
		     throw new RuntimeException("Password did not matched, please try again");
		 }
		
	}

	@Override
	public void withdrawAmount(int agentId, int withdrawAmount) {
		Session session = entityManager.unwrap(Session.class);
		Agent agent = session.get(Agent.class, agentId);
		if(withdrawAmount>agent.getTotalBalance() || withdrawAmount<=0) {
			throw new RuntimeException("AMount greater or smaller");
		}
		agent.setTotalBalance(agent.getTotalBalance()-withdrawAmount);
		Transactions transactions=new Transactions("WITHDRAW", withdrawAmount, agentId, new Date());
		session.saveOrUpdate(agent);
		session.saveOrUpdate(transactions);
		
	}

}

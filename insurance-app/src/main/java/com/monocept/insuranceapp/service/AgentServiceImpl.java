package com.monocept.insuranceapp.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monocept.insuranceapp.dao.AgentDao;
import com.monocept.insuranceapp.email.EmailSenderService;
import com.monocept.insuranceapp.entity.Agent;
import com.monocept.insuranceapp.entity.InstallmentPayments;
import com.monocept.insuranceapp.utility.ChangePassword;
import com.monocept.insuranceapp.utility.Mail;
import com.monocept.insuranceapp.utility.WithdrawCommision;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentDao agentDao;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private EmailSenderService senderService;

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

	@Override
	public void sendMail(Mail mailBody) {
		String mail=mailBody.getEmailId();
		String subject=mailBody.getSubject();
		String body=mailBody.getMessage()+" Use My Agent Id :"+mailBody.getAgentId();
		senderService.sendEmail(mail, subject, body);
		
	}

	@Override
	@Transactional
	public void changePassword(ChangePassword passwordBody, int agentId) {
		agentDao.changePassword(passwordBody,agentId);
		
	}


	@Override
	@Transactional
	public List<InstallmentPayments> getInstallmentPayments() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from InstallmentPayments");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void withdrawAmount(WithdrawCommision withdrawBody, int agentId) {
		agentDao.withdrawAmount(withdrawBody,agentId);
		
	}


}

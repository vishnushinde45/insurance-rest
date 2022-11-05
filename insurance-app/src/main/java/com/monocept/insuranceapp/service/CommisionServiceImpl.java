package com.monocept.insuranceapp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.insuranceapp.dao.CommisionDao;
import com.monocept.insuranceapp.entity.Commision;

@Service
public class CommisionServiceImpl implements CommisionService {

	@Autowired
	private CommisionDao commisionDao;
	
	@Autowired
	EntityManager entityManager;

	@Override
	@Transactional
	public List<Commision> getCommisionByAgentId(int agentId) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Commision where agent_id=:agentId");
		query.setParameter("agentId", agentId);
		List resultList = query.getResultList();
		return resultList;
	}

	@Override
	@Transactional
	public List<Commision> getAllCommisions() {
		List<Commision> list = commisionDao.findAll();
		return list;
	}
	
}

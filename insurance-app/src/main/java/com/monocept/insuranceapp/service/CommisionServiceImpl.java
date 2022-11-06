package com.monocept.insuranceapp.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.insuranceapp.dao.CommisionDao;
import com.monocept.insuranceapp.dao.CommisionTransactionsDao;
import com.monocept.insuranceapp.entity.Commision;
import com.monocept.insuranceapp.entity.CommisionTransactions;

@Service
public class CommisionServiceImpl implements CommisionService {

	@Autowired
	private CommisionDao commisionDao;
	
	@Autowired
	private CommisionTransactionsDao commisionTransactionsDao;
	
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

	@Override
	@Transactional
	public List<CommisionTransactions> getCommisionWithdrawls() {
		List<CommisionTransactions> allTransactions = commisionTransactionsDao.findAll();
		List<CommisionTransactions> withdrawls = allTransactions.stream().filter(transaction->transaction.getTransactionType().equalsIgnoreCase("WITHDRAW")).collect(Collectors.toList());
		return withdrawls;
	}
	
}

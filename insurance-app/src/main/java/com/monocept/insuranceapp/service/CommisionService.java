package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.Commision;
import com.monocept.insuranceapp.entity.CommisionTransactions;

public interface CommisionService {

	List<Commision> getCommisionByAgentId(int agentId);

	List<Commision> getAllCommisions();

	List<CommisionTransactions> getCommisionWithdrawls();

}

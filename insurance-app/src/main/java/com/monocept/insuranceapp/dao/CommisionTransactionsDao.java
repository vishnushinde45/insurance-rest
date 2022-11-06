package com.monocept.insuranceapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.insuranceapp.entity.CommisionTransactions;

public interface CommisionTransactionsDao extends JpaRepository<CommisionTransactions, Integer>{

}

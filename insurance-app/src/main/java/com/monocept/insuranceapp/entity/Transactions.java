package com.monocept.insuranceapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.monocept.insuranceapp.enums.TransactionType;
@Entity
@Table(name = "transactions")
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "transaction_type")
	private TransactionType transactionType;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "agent_id")
	private int agentId;
	
	@Column(name = "date")
	private Date date;

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Transactions(TransactionType transactionType, double amount, int agentId, Date date) {
		super();
		this.transactionType = transactionType;
		this.amount = amount;
		this.agentId = agentId;
		this.date = date;
	}

	public Transactions(int id, TransactionType transactionType, double amount, int agentId, Date date) {
		super();
		this.id = id;
		this.transactionType = transactionType;
		this.amount = amount;
		this.agentId = agentId;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", transactionType=" + transactionType + ", amount=" + amount + ", agentId="
				+ agentId + ", date=" + date + "]";
	}
	
	
	
}

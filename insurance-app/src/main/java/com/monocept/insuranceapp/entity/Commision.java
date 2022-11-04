package com.monocept.insuranceapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="commision")
public class Commision {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "agent_id")
	private int agentId;
	
	@Column(name = "agent_name")
	private String agentName;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "commision_type")
	private String commisionType;

	public Commision() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commision(int agentId, String agentName, String customerName, int customerId, double amount,
			String commisionType) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.customerName = customerName;
		this.customerId = customerId;
		this.amount = amount;
		this.commisionType = commisionType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCommisionType() {
		return commisionType;
	}

	public void setCommisionType(String commisionType) {
		this.commisionType = commisionType;
	}

	@Override
	public String toString() {
		return "Commision [id=" + id + ", agentId=" + agentId + ", agentName=" + agentName + ", customerName="
				+ customerName + ", customerId=" + customerId + ", amount=" + amount + ", commisionType="
				+ commisionType + "]";
	}
	
	

	
	
	

}

package com.monocept.insuranceapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.monocept.insuranceapp.enums.CommisionType;

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
	private CommisionType commisionType;

	public Commision() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commision(int id, int agentId, String agentName, String customerName, int customerId, double amount,
			CommisionType commisionType) {
		super();
		this.id = id;
		this.agentId = agentId;
		this.agentName = agentName;
		this.customerName = customerName;
		this.customerId = customerId;
		this.amount = amount;
		this.commisionType = commisionType;
	}

	public Commision(int agentId, String agentName, String customerName, int customerId, double amount,
			CommisionType commisionType) {
		super();
		this.agentId = agentId;
		this.agentName = agentName;
		this.customerName = customerName;
		this.customerId = customerId;
		this.amount = amount;
		this.commisionType = commisionType;
	}

	@Override
	public String toString() {
		return "Commision [id=" + id + ", agentId=" + agentId + ", agentName=" + agentName + ", customerName="
				+ customerName + ", customerId=" + customerId + ", amount=" + amount + ", commisionType="
				+ commisionType + "]";
	}
	
	
	

}

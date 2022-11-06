package com.monocept.insuranceapp.utility;

public class WithdrawCommision {
	
	private String fullName;
	private int agentId;
	private int amount;
	public WithdrawCommision() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WithdrawCommision(String fullName, int agentId, int amount) {
		super();
		this.fullName = fullName;
		this.agentId = agentId;
		this.amount = amount;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}

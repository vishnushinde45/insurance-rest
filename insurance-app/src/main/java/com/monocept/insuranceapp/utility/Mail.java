package com.monocept.insuranceapp.utility;

public class Mail {
	private String emailId;
	private String subject;
	private String message;
	private int agentId;
	public Mail(String emailId, String subject, String message, int agentId) {
		super();
		this.emailId = emailId;
		this.subject = subject;
		this.message = message;
		this.agentId = agentId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	
	

}

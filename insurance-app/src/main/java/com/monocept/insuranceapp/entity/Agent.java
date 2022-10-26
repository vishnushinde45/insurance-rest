package com.monocept.insuranceapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agent")
public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "qualification")
	private String qualification;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "agent_code")
	private String agentCode;

	public Agent() {}

	public Agent(int id, String fullName, String username, String password, String state, String city, String emailId,
			String qualification, String status, int employeeId, String agentCode) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.state = state;
		this.city = city;
		this.emailId = emailId;
		this.qualification = qualification;
		this.status = status;
		this.employeeId = employeeId;
		this.agentCode = agentCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", fullName=" + fullName + ", username=" + username + ", password=" + password
				+ ", state=" + state + ", city=" + city + ", emailId=" + emailId + ", qualification=" + qualification
				+ ", status=" + status + ", employeeId=" + employeeId + ", agentCode=" + agentCode + "]";
	}
	
	
	
	
}

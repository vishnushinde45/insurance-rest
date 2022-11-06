package com.monocept.insuranceapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	
	@Column(name = "admin_id")
	private int adminId;
	
	@Column(name = "email_id")
	private String emailId;

	public Employee() {
		super();
	
	}

	public Employee(String fullName, String username, String password, String state, String city,
			int adminId, String emailId) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.state = state;
		this.city = city;
		this.adminId = adminId;
		this.emailId = emailId;
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

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}




}

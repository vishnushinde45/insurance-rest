package com.monocept.insuranceapp.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
     
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
	
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "pincode")
	private int pincode;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "nominee_name")
	private String nomineeName;
	
	@Column(name = "nominee_relation")
	private String nomineeRelation;
	
	@Column(name = "agent_id")
	private int agentId;
	
	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, mappedBy = "customer")
	private List<EnrolledPolicies> enrolledPolicies;
	
	public Customer() {}

	public Customer(int id, String fullName, String username, String password, Date dateOfBirth, String address,
			String emailId, String state, String city, int pincode, String mobileNo, String nomineeName,
			String nomineeRelation, int agentId) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.emailId = emailId;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.mobileNo = mobileNo;
		this.nomineeName = nomineeName;
		this.nomineeRelation = nomineeRelation;
		this.agentId = agentId;
	}
	
	
	public void enrollPolicy(EnrolledPolicies enrollPolicy) {
		if(enrolledPolicies==null) {
			enrolledPolicies=new ArrayList<EnrolledPolicies>();
		}
		enrollPolicy.setCustomer(this);
		enrolledPolicies.add(enrollPolicy);
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getNomineeRelation() {
		return nomineeRelation;
	}

	public void setNomineeRelation(String nomineeRelation) {
		this.nomineeRelation = nomineeRelation;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", fullName=" + fullName + ", username=" + username + ", password=" + password
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", emailId=" + emailId + ", state=" + state
				+ ", city=" + city + ", pincode=" + pincode + ", mobileNo=" + mobileNo + ", nomineeName=" + nomineeName
				+ ", nomineeRelation=" + nomineeRelation + ", agentId=" + agentId + "]";
	}
	
	
	
}

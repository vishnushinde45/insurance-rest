package com.monocept.insuranceapp.entity;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.monocept.insuranceapp.enums.PremiumType;

@Entity
@Table(name = "enrolled_policies")
public class EnrolledPolicies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "insurance_scheme_id")
	private int insuranceSchemeId;
	
	@Column(name = "enroll_date")
	private Date enrollDate;
	
	@Column(name = "maturity_date")
	private Date maturityDate;
	
	@Column(name = "enroll_time")
	private Time enrollTime;
	
	@Column(name = "invested_amount")
	private double investedAmount;
	
	@Column(name = "interest_amount")
	private double interestAmount;
	
	@Column(name = "sum_assured")
	private double sumAssured;
	
	@Column(name = "profit_ratio")
	private double profitRatio;
	
	@Column(name = "policy_term")
	private int policyTerm;
	
	@Column(name = "premium_type")
	private PremiumType premiumType;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "installments_id")
	private Installments installments;

	public EnrolledPolicies() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public EnrolledPolicies(int id, int insuranceSchemeId, Date enrollDate, Date maturityDate, Time enrollTime,
			double investedAmount, double interestAmount, double sumAssured, double profitRatio, int policyTerm,
			PremiumType premiumType, Customer customer) {
		super();
		this.id = id;
		this.insuranceSchemeId = insuranceSchemeId;
		this.enrollDate = enrollDate;
		this.maturityDate = maturityDate;
		this.enrollTime = enrollTime;
		this.investedAmount = investedAmount;
		this.interestAmount = interestAmount;
		this.sumAssured = sumAssured;
		this.profitRatio = profitRatio;
		this.policyTerm = policyTerm;
		this.premiumType = premiumType;
		this.customer = customer;
	}



	public EnrolledPolicies(int insuranceSchemeId, Date enrollDate, Date maturityDate, Time enrollTime,
			double investedAmount, double interestAmount, double sumAssured, double profitRatio, int policyTerm,
			PremiumType premiumType, Customer customer) {
		super();
		this.insuranceSchemeId = insuranceSchemeId;
		this.enrollDate = enrollDate;
		this.maturityDate = maturityDate;
		this.enrollTime = enrollTime;
		this.investedAmount = investedAmount;
		this.interestAmount = interestAmount;
		this.sumAssured = sumAssured;
		this.profitRatio = profitRatio;
		this.policyTerm = policyTerm;
		this.premiumType = premiumType;
		this.customer = customer;
	}



	public PremiumType getPremiumType() {
		return premiumType;
	}



	public void setPremiumType(PremiumType premiumType) {
		this.premiumType = premiumType;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInsuranceSchemeId() {
		return insuranceSchemeId;
	}

	public void setInsuranceSchemeId(int insuranceSchemeId) {
		this.insuranceSchemeId = insuranceSchemeId;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Time getEnrollTime() {
		return enrollTime;
	}

	public void setEnrollTime(Time enrollTime) {
		this.enrollTime = enrollTime;
	}

	public double getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(double investedAmount) {
		this.investedAmount = investedAmount;
	}

	public double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}

	public double getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(double sumAssured) {
		this.sumAssured = sumAssured;
	}

	public double getProfitRatio() {
		return profitRatio;
	}

	public void setProfitRatio(double profitRatio) {
		this.profitRatio = profitRatio;
	}

	public int getPolicyTerm() {
		return policyTerm;
	}

	public void setPolicyTerm(int policyTerm) {
		this.policyTerm = policyTerm;
	}
	
	

}

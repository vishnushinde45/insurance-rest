package com.monocept.insuranceapp.entity;



import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "enrolled_policies")
@JsonIgnoreProperties(value = {
	    "customer"
	})
public class EnrolledPolicies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "insurance_scheme_id")
	private int insuranceSchemeId;
	
	@Column(name = "insurance_type")
	private String insuranceType;
	
	@Column(name = "insurance_scheme_name")
	private String insuranceSchemeName;
	
	
	@Column(name = "enroll_date")
	@Temporal(TemporalType.DATE)
	private Date enrollDate;
	
	@Column(name = "maturity_date")
	@Temporal(TemporalType.DATE)
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
	private int premiumType;
	
	@Column(name = "installment_amount")
	private int installmentAmount;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, mappedBy = "enrolledPolicies")
	private List<Installments> installments;
	

	public EnrolledPolicies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnrolledPolicies(int id, int insuranceSchemeId, Date enrollDate, Date maturityDate, Time enrollTime,
			double investedAmount, double interestAmount, double sumAssured, double profitRatio, int policyTerm,
			int premiumType, int installmentAmount, Customer customer) {
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
		this.installmentAmount = installmentAmount;
		this.customer = customer;
		
	}
	
	public void addInstallment(Installments installment) {
		if(installments==null) {
			installments=new ArrayList<Installments>();
		}
		installments.add(installment);
		installment.setEnrolledPolicies(this);
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

	public int getPremiumType() {
		return premiumType;
	}

	public void setPremiumType(int premiumType) {
		this.premiumType = premiumType;
	}

	public int getInstallmentAmount() {
		return installmentAmount;
	}

	public void setInstallmentAmount(int installmentAmount) {
		this.installmentAmount = installmentAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<Installments> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installments> installments) {
		this.installments = installments;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getInsuranceSchemeName() {
		return insuranceSchemeName;
	}

	public void setInsuranceSchemeName(String insuranceSchemeName) {
		this.insuranceSchemeName = insuranceSchemeName;
	}

	

	
	
	

}

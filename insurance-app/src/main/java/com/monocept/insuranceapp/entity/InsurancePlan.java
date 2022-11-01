package com.monocept.insuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "insurance_plan")
public class InsurancePlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "min_policy_term")
	private int minimumPolicyTerm;

	@Column(name = "max_policy_term")
	private int maximumPolicyTerm;

	@Column(name = "min_age")
	private int minimumAge;

	@Column(name = "max_age")
	private int maximumAge;

	@Column(name = "min_investment")
	private int minimumInvestment;

	@Column(name = "max_investment")
	private int maximumInvestment;

	@Column(name = "profit_ratio")
	private double profitRatio;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "insurancePlan")
	private InsuranceScheme insuranceScheme;

	public InsurancePlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsurancePlan(int id, int minimumPolicyTerm, int maximumPolicyTerm, int minimumAge, int maximumAge,
			int minimumInvestment, int maximumInvestment, double profitRatio) {
		super();
		this.id = id;
		this.minimumPolicyTerm = minimumPolicyTerm;
		this.maximumPolicyTerm = maximumPolicyTerm;
		this.minimumAge = minimumAge;
		this.maximumAge = maximumAge;
		this.minimumInvestment = minimumInvestment;
		this.maximumInvestment = maximumInvestment;
		this.profitRatio = profitRatio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMinimumPolicyTerm() {
		return minimumPolicyTerm;
	}

	public void setMinimumPolicyTerm(int minimumPolicyTerm) {
		this.minimumPolicyTerm = minimumPolicyTerm;
	}

	public int getMaximumPolicyTerm() {
		return maximumPolicyTerm;
	}

	public void setMaximumPolicyTerm(int maximumPolicyTerm) {
		this.maximumPolicyTerm = maximumPolicyTerm;
	}

	public int getMinimumAge() {
		return minimumAge;
	}

	public void setMinimumAge(int minimumAge) {
		this.minimumAge = minimumAge;
	}

	public int getMaximumAge() {
		return maximumAge;
	}

	public void setMaximumAge(int maximumAge) {
		this.maximumAge = maximumAge;
	}

	public int getMinimumInvestment() {
		return minimumInvestment;
	}

	public void setMinimumInvestment(int minimumInvestment) {
		this.minimumInvestment = minimumInvestment;
	}

	public int getMaximumInvestment() {
		return maximumInvestment;
	}

	public void setMaximumInvestment(int maximumInvestment) {
		this.maximumInvestment = maximumInvestment;
	}

	public double getProfitRatio() {
		return profitRatio;
	}

	public void setProfitRatio(double profitRatio) {
		this.profitRatio = profitRatio;
	}

	public InsuranceScheme getInsuranceScheme() {
		return insuranceScheme;
	}

	public void setInsuranceScheme(InsuranceScheme insuranceScheme) {
		this.insuranceScheme = insuranceScheme;
	}

	@Override
	public String toString() {
		return "InsurancePlan [id=" + id + ", minimumPolicyTerm=" + minimumPolicyTerm + ", maximumPolicyTerm="
				+ maximumPolicyTerm + ", minimumAge=" + minimumAge + ", maximumAge=" + maximumAge
				+ ", minimumInvestment=" + minimumInvestment + ", maximumInvestment=" + maximumInvestment
				+ ", profitRatio=" + profitRatio + "]";
	}

}

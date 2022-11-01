package com.monocept.insuranceapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insurance_settings")
public class InsuranceSettings {   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "tax")
	private double tax;
	
	@Column(name = "claim_deduction")
	private double claimDeduction;

	public InsuranceSettings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsuranceSettings(double tax, double claimDeduction) {
		super();
		this.tax = tax;
		this.claimDeduction = claimDeduction;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getClaimDeduction() {
		return claimDeduction;
	}

	public void setClaimDeduction(double claimDeduction) {
		this.claimDeduction = claimDeduction;
	}
	
	
}

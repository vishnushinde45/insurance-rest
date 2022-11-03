package com.monocept.insuranceapp.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.monocept.insuranceapp.enums.InstallmentStatus;

@Entity
@Table(name = "installments")
public class Installments {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "installment_amount")
	private double installmentAmount;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "status")
	private InstallmentStatus status;
	
	@Column(name = "payment_mode")
	private String paymentMode;
	
	@Column(name = "total_amount_paid")
	private double totalAmountPaid;
	
	@OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}, mappedBy = "installments")
	private EnrolledPolicies enrolledPolicies;

	public Installments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Installments(double installmentAmount, Date date, InstallmentStatus status, String paymentMode,
			double totalAmountPaid, EnrolledPolicies enrolledPolicies) {
		super();
		this.installmentAmount = installmentAmount;
		this.date = date;
		this.status = status;
		this.paymentMode = paymentMode;
		this.totalAmountPaid = totalAmountPaid;
		this.enrolledPolicies = enrolledPolicies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getInstallmentAmount() {
		return installmentAmount;
	}

	public void setInstallmentAmount(double installmentAmount) {
		this.installmentAmount = installmentAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public InstallmentStatus getStatus() {
		return status;
	}

	public void setStatus(InstallmentStatus status) {
		this.status = status;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public double getTotalAmountPaid() {
		return totalAmountPaid;
	}

	public void setTotalAmountPaid(double totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}

	public EnrolledPolicies getEnrolledPolicies() {
		return enrolledPolicies;
	}

	public void setEnrolledPolicies(EnrolledPolicies enrolledPolicies) {
		this.enrolledPolicies = enrolledPolicies;
	}
	
	
	
	
}

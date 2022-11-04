package com.monocept.insuranceapp.entity;



import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "installments")
@JsonIgnoreProperties(value = {
	    "enrolledPolicies"
})
public class Installments {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "installment_amount")
	private double installmentAmount;
	
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "payment_mode")
	private String paymentMode;
	
	@Column(name = "total_amount_paid")
	private double totalAmountPaid;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "enrolled_policy_id")
	private EnrolledPolicies enrolledPolicies;

	public Installments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Installments(double installmentAmount, Date date, String status,double totalAmountPaid) {
		super();
		this.installmentAmount = installmentAmount;
		this.date = date;
		this.status = status;
		this.totalAmountPaid = totalAmountPaid;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	@Override
	public String toString() {
		return "Installments [id=" + id + ", installmentAmount=" + installmentAmount + ", date=" + date + ", status="
				+ status + ", paymentMode=" + paymentMode + ", totalAmountPaid=" + totalAmountPaid
				+ ", enrolledPolicies=" + enrolledPolicies + "]";
	}

	
	
	
	
}

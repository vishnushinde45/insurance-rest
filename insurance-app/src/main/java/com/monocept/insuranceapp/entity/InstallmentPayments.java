package com.monocept.insuranceapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "installments_payments")
public class InstallmentPayments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "installment_amount")
	private double installmentAmount;
	
	@Column(name = "payment_date")
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "payment_type")
	private String paymentType;

	public InstallmentPayments(double installmentAmount, Date paymentDate, int customerId, String customerName,
			String paymentType) {
		super();
		this.installmentAmount = installmentAmount;
		this.paymentDate = paymentDate;
		this.customerId = customerId;
		this.customerName = customerName;
		this.paymentType = paymentType;
	}

	
	public InstallmentPayments() {
		super();
		// TODO Auto-generated constructor stub
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

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	
	
	
	
}

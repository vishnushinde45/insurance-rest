package com.monocept.insuranceapp.entity;

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

@Entity
@Table(name = "documents")
public class Documents {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "pancard_url")
	private String panCardUrl;
	
	@Column(name = "aadharcard_url")
	private String aadharCardUrl;
	
	@Column(name = "bankpassbook_url")
	private String bankPassbookUrl;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "documents")
	private Customer customer;

	public Documents() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Documents(String panCardUrl, String aadharCardUrl, String bankPassbookUrl) {
		super();
		this.panCardUrl = panCardUrl;
		this.aadharCardUrl = aadharCardUrl;
		this.bankPassbookUrl = bankPassbookUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPanCardUrl() {
		return panCardUrl;
	}

	public void setPanCardUrl(String panCardUrl) {
		this.panCardUrl = panCardUrl;
	}

	public String getAadharCardUrl() {
		return aadharCardUrl;
	}

	public void setAadharCardUrl(String aadharCardUrl) {
		this.aadharCardUrl = aadharCardUrl;
	}

	public String getBankPassbookUrl() {
		return bankPassbookUrl;
	}

	public void setBankPassbookUrl(String bankPassbookUrl) {
		this.bankPassbookUrl = bankPassbookUrl;
	}
	
	
	

}

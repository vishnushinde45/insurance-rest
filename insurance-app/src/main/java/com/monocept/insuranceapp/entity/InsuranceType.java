package com.monocept.insuranceapp.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "insurance_type")
public class InsuranceType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "insurance_type")
	private String insuranceType;
	
	@Column(name = "status")
	private String status;
	
	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY)
	private List<InsuranceScheme> insuranceSchemes;
	
	public InsuranceType() {}

	public InsuranceType(int id, String insuranceType, String status, List<InsuranceScheme> insuranceSchemes) {
		super();
		this.id = id;
		this.insuranceType = insuranceType;
		this.status = status;
		this.insuranceSchemes = insuranceSchemes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<InsuranceScheme> getInsuranceSchemes() {
		return insuranceSchemes;
	}

	public void setInsuranceSchemes(List<InsuranceScheme> insuranceSchemes) {
		this.insuranceSchemes = insuranceSchemes;
	}

	@Override
	public String toString() {
		return "InsuranceType [id=" + id + ", insuranceType=" + insuranceType + ", status=" + status
				+ ", insuranceSchemes=" + insuranceSchemes + "]";
	}

	
	

}

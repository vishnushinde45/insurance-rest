package com.monocept.insuranceapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.monocept.insuranceapp.image.SchemeImage;

@Entity
@Table(name = "insurance_scheme")
public class InsuranceScheme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "insurance_scheme_name")
	private String insuranceSchemeName;

	@Column(name = "commision_for_new_registration")
	private Double commisionForNewRegistration;

	@Column(name = "commision_for_installment")
	private Double commisionForInstallment;

	@Lob
	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private String status;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "scheme_image_id")
	private SchemeImage schemeImage;
	
	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "insurance_plan_id")
	private InsurancePlan insurancePlan;

	public InsuranceScheme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsuranceScheme(int id, String insuranceSchemeName, Double commisionForNewRegistration,
			Double commisionForInstallment, String description, String status, SchemeImage schemeImage,
			InsurancePlan insurancePlan) {
		super();
		this.id = id;
		this.insuranceSchemeName = insuranceSchemeName;
		this.commisionForNewRegistration = commisionForNewRegistration;
		this.commisionForInstallment = commisionForInstallment;
		this.description = description;
		this.status = status;
		this.schemeImage = schemeImage;
		this.insurancePlan = insurancePlan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInsuranceSchemeName() {
		return insuranceSchemeName;
	}

	public void setInsuranceSchemeName(String insuranceSchemeName) {
		this.insuranceSchemeName = insuranceSchemeName;
	}

	public Double getCommisionForNewRegistration() {
		return commisionForNewRegistration;
	}

	public void setCommisionForNewRegistration(Double commisionForNewRegistration) {
		this.commisionForNewRegistration = commisionForNewRegistration;
	}

	public Double getCommisionForInstallment() {
		return commisionForInstallment;
	}

	public void setCommisionForInstallment(Double commisionForInstallment) {
		this.commisionForInstallment = commisionForInstallment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SchemeImage getSchemeImage() {
		return schemeImage;
	}

	public void setSchemeImage(SchemeImage schemeImage) {
		this.schemeImage = schemeImage;
	}

	public InsurancePlan getInsurancePlan() {
		return insurancePlan;
	}

	public void setInsurancePlan(InsurancePlan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}

	@Override
	public String toString() {
		return "InsuranceScheme [id=" + id + ", insuranceSchemeName=" + insuranceSchemeName
				+ ", commisionForNewRegistration=" + commisionForNewRegistration + ", commisionForInstallment="
				+ commisionForInstallment + ", description=" + description + ", status=" + status + ", schemeImage="
				+ schemeImage + ", insurancePlan=" + insurancePlan + "]";
	}
	
	

}

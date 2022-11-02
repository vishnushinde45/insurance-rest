package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.InsurancePlan;

public interface InsurancePlanService {

	void addInsurancePlan(InsurancePlan insurancePlan, int insuranceTypeId, int insuranceSchemeId);

	List<InsurancePlan> getInsurancePlans();

}

package com.monocept.insuranceapp.service;

import com.monocept.insuranceapp.entity.InsurancePlan;

public interface InsurancePlanService {

	void addInsurancePlan(InsurancePlan insurancePlan, int insuranceTypeId, int insuranceSchemeId);

}

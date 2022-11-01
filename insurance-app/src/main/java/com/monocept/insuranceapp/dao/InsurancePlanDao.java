package com.monocept.insuranceapp.dao;

import com.monocept.insuranceapp.entity.InsurancePlan;

public interface InsurancePlanDao {

	void addInsurancePlan(InsurancePlan insurancePlan, int insuranceTypeId, int insuranceSchemeId);

}

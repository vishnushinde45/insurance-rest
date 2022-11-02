package com.monocept.insuranceapp.dao;

import java.util.List;

import com.monocept.insuranceapp.entity.InsurancePlan;

public interface InsurancePlanDao {

	void addInsurancePlan(InsurancePlan insurancePlan, int insuranceTypeId, int insuranceSchemeId);

	List<InsurancePlan> getInsurancePlans();

}

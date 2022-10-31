package com.monocept.insuranceapp.service;

import java.util.List;
import com.monocept.insuranceapp.entity.InsurancePlan;

public interface InsurancePlanService {

	List<InsurancePlan> getInsurancePlan();

	InsurancePlan getInsurancePlan(int planId);

	InsurancePlan addInsurancePlan(InsurancePlan insurancePlan);

	InsurancePlan updateInsurancePlan(InsurancePlan insurancePlan);

	InsurancePlan deleteInsurancePlan(int planId);

}

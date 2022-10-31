package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.InsuranceType;

public interface InsuranceTypeService {

	InsuranceType addInsuranceType(InsuranceType insuranceType);

	List<InsuranceType> getInsuranceTypes();



	

}

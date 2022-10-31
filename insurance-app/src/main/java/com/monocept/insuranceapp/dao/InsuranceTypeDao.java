package com.monocept.insuranceapp.dao;

import java.util.List;

import com.monocept.insuranceapp.entity.InsuranceType;

public interface InsuranceTypeDao {

	InsuranceType addInsuranceType(InsuranceType insuranceType);

	List<InsuranceType> getInsuranceTypes();

	

}

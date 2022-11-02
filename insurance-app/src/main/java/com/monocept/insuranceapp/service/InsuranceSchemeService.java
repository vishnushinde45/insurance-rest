package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.InsuranceScheme;

public interface InsuranceSchemeService {

	InsuranceScheme addInsuranceScheme(InsuranceScheme insuranceScheme, int id);

	List<InsuranceScheme> getInsuranceSchemes();

	List<InsuranceScheme> getInsuranceSchemesByTypeId(int insuranceTypeId);

}

package com.monocept.insuranceapp.dao;

import java.util.List;

import com.monocept.insuranceapp.entity.InsuranceScheme;

public interface InsuranceSchemeDao {

	InsuranceScheme addInsuranceScheme(InsuranceScheme insuranceScheme,int id);

	List<InsuranceScheme> getInsuranceSchemes();

}

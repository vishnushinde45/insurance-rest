package com.monocept.insuranceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monocept.insuranceapp.dao.InsuranceTypeDao;
import com.monocept.insuranceapp.entity.InsuranceType;

@Service
public class InsuranceTypeServiceImpl implements InsuranceTypeService {

	@Autowired
	private InsuranceTypeDao insuranceTypeDao;

	@Override
	@Transactional
	public InsuranceType addInsuranceType(InsuranceType insuranceType) {
		InsuranceType insurance=insuranceTypeDao.addInsuranceType(insuranceType);
		return insurance;
	}

	@Override
	@Transactional
	public List<InsuranceType> getInsuranceTypes() {
		// TODO Auto-generated method stub
		return insuranceTypeDao.getInsuranceTypes();
	}

	
}

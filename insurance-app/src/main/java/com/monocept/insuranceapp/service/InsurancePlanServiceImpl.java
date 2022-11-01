package com.monocept.insuranceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monocept.insuranceapp.dao.InsurancePlanDao;
import com.monocept.insuranceapp.entity.InsurancePlan;

@Service
public class InsurancePlanServiceImpl implements InsurancePlanService {

	@Autowired
	private InsurancePlanDao insurancePlanDao;

	@Override
	@Transactional
	public void addInsurancePlan(InsurancePlan insurancePlan, int insuranceTypeId, int insuranceSchemeId) {
		insurancePlanDao.addInsurancePlan(insurancePlan,insuranceTypeId,insuranceSchemeId);

	}

}

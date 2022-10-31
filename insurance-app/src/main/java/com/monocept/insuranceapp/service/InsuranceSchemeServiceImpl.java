package com.monocept.insuranceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monocept.insuranceapp.dao.InsuranceSchemeDao;
import com.monocept.insuranceapp.entity.InsuranceScheme;


@Service
public class InsuranceSchemeServiceImpl implements InsuranceSchemeService {
    
	@Autowired
	private InsuranceSchemeDao insuranceSchemeDao;
	
	@Override
	@Transactional
	public InsuranceScheme addInsuranceScheme(InsuranceScheme insuranceScheme) {
		return insuranceSchemeDao.addInsuranceScheme(insuranceScheme);
	}

}

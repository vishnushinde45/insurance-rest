package com.monocept.insuranceapp.service;

import java.util.List;

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
	public InsuranceScheme addInsuranceScheme(InsuranceScheme insuranceScheme, int id) {
		return insuranceSchemeDao.addInsuranceScheme(insuranceScheme,id);
	}

	@Override
	@Transactional
	public List<InsuranceScheme> getInsuranceSchemes() {
		// TODO Auto-generated method stub
		return insuranceSchemeDao.getInsuranceSchemes();
	}

	@Override
	@Transactional
	public List<InsuranceScheme> getInsuranceSchemesByTypeId(int insuranceTypeId) {
		// TODO Auto-generated method stub
		return insuranceSchemeDao.getInsuranceSchemesByTypeId(insuranceTypeId);
	}

}

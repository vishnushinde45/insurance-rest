package com.monocept.insuranceapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.insuranceapp.entity.InsuranceType;

@Repository
public class InsuranceTypeDaoImpl implements InsuranceTypeDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public InsuranceType addInsuranceType(InsuranceType insuranceType) {
		Session session = entityManager.unwrap(Session.class);
		session.save(insuranceType);
		return insuranceType;

	}

	@Override
	public List<InsuranceType> getInsuranceTypes() {
		Session session = entityManager.unwrap(Session.class);
		List resultList = session.createQuery("from InsuranceType").getResultList();
		if(resultList==null)
			throw new RuntimeException("Insurance Types is not available");
		return resultList;
	}

}

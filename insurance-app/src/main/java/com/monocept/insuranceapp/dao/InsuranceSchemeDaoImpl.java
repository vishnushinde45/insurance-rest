package com.monocept.insuranceapp.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.insuranceapp.entity.InsuranceScheme;

@Repository
public class InsuranceSchemeDaoImpl implements InsuranceSchemeDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public InsuranceScheme addInsuranceScheme(InsuranceScheme insuranceScheme) {
		Session session = entityManager.unwrap(Session.class);
		session.save(insuranceScheme);
		return insuranceScheme;
	}

}

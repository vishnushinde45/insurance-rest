package com.monocept.insuranceapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.insuranceapp.entity.InsuranceScheme;
import com.monocept.insuranceapp.entity.InsuranceType;

@Repository
public class InsuranceSchemeDaoImpl implements InsuranceSchemeDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public InsuranceScheme addInsuranceScheme(InsuranceScheme insuranceScheme,int id) {
		Session session = entityManager.unwrap(Session.class);
		InsuranceType type=session.get(InsuranceType.class, id);
		type.addScheme(insuranceScheme);
		session.save(type);
		return insuranceScheme;
	}

	@Override
	public List<InsuranceScheme> getInsuranceSchemes() {
		Session session = entityManager.unwrap(Session.class);
		List resultList = session.createQuery("from InsuranceScheme").getResultList();
		return resultList;
	}

}

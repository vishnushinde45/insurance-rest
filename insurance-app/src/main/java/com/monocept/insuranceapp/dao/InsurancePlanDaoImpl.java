package com.monocept.insuranceapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.insuranceapp.entity.InsurancePlan;
import com.monocept.insuranceapp.entity.InsuranceScheme;
import com.monocept.insuranceapp.entity.InsuranceType;

@Repository
public class InsurancePlanDaoImpl implements InsurancePlanDao {
	@Autowired
	EntityManager EntityManager;

	@Override
	public void addInsurancePlan(InsurancePlan insurancePlan, int insuranceTypeId, int insuranceSchemeId) {
        Session session = EntityManager.unwrap(Session.class);
        InsuranceType insuranceType = session.get(InsuranceType.class, insuranceTypeId);
        List<InsuranceScheme> insuranceSchemes = insuranceType.getInsuranceSchemes();
        InsuranceScheme insuranceScheme=null;
        for(InsuranceScheme scheme:insuranceSchemes) {
        	if(scheme.getId()==insuranceSchemeId)
        		insuranceScheme=scheme;
        }
        insuranceScheme.setInsurancePlan(insurancePlan);
        
        
	}

	@Override
	public List<InsurancePlan> getInsurancePlans() {
		 Session session = EntityManager.unwrap(Session.class);
		 Query query = session.createQuery("from InsurancePlan");
		 List resultList = query.getResultList();
		return resultList;
	}

	@Override
	public InsurancePlan getInsurancePlan(int id) {
		Session session = EntityManager.unwrap(Session.class);
		InsurancePlan insurancePlan = session.get(InsurancePlan.class, id);
		return insurancePlan;
	}

}

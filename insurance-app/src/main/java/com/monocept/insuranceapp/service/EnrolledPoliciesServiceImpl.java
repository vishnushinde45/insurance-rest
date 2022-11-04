package com.monocept.insuranceapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.insuranceapp.dao.EnrolledPoliciesDao;
import com.monocept.insuranceapp.entity.Agent;
import com.monocept.insuranceapp.entity.Commision;
import com.monocept.insuranceapp.entity.Customer;
import com.monocept.insuranceapp.entity.EnrolledPolicies;
import com.monocept.insuranceapp.entity.Installments;
import com.monocept.insuranceapp.entity.InsuranceScheme;
import com.monocept.insuranceapp.entity.InsuranceType;
import com.monocept.insuranceapp.entity.Transactions;
import com.monocept.insuranceapp.utility.InstallmentCalculator;

@Service
public class EnrolledPoliciesServiceImpl implements EnrolledPoliciesService {

	@Autowired
	EntityManager entityManager;
	@Autowired
	private EnrolledPoliciesDao enrolledPoliciesDao;
	
	private final static int percentage=100;
	
	
	@Override
	@Transactional
	public int buyPolicy(EnrolledPolicies enrolledPolicy, int customerId) {
		
		Date enrolledDate=this.getCurrentDate();
		Date maturityDate=this.getMaturityDate(enrolledDate,enrolledPolicy.getPolicyTerm());
		
		Session session = entityManager.unwrap(Session.class);
		Customer customer = session.get(Customer.class, customerId);
		InsuranceScheme insuranceScheme = session.get(InsuranceScheme.class, enrolledPolicy.getInsuranceSchemeId());
		if(customer.getAgentId()!=0) {
			Agent agent = session.get(Agent.class, customer.getAgentId());
			
			double commisionAmount= (enrolledPolicy.getInvestedAmount()/percentage)*insuranceScheme.getCommisionForNewRegistration();
			Commision commision=new Commision(agent.getId(), agent.getFullName(), customer.getFullName(), customer.getId(), commisionAmount, "NewRegistration");
			agent.setTotalBalance(agent.getTotalBalance()+commisionAmount);
			
			Transactions transactions=new Transactions("Deposit", commisionAmount, agent.getId(), enrolledDate);
			session.save(transactions);
			session.save(agent);
			session.save(commision);
			
		}
		enrolledPolicy.setSumAssured(enrolledPolicy.getInterestAmount()+enrolledPolicy.getInvestedAmount());
		enrolledPolicy.setEnrollDate(enrolledDate);
		enrolledPolicy.setMaturityDate(maturityDate);
		enrolledPolicy.setInsuranceSchemeName(insuranceScheme.getInsuranceSchemeName());
		InsuranceType insuranceType = insuranceScheme.getInsuranceType();
		enrolledPolicy.setInsuranceType(insuranceType.getInsuranceType());
		
		List<Installments> calculatedInstallments=InstallmentCalculator.getInstallments(enrolledPolicy.getInvestedAmount(),
				enrolledPolicy.getPremiumType(),enrolledDate,enrolledPolicy.getPolicyTerm());
		customer.enrollPolicy(enrolledPolicy);
		
		for(Installments installment:calculatedInstallments) {
			
			enrolledPolicy.addInstallment(installment);
			
		}
		session.save(customer);
		System.out.println(enrolledPolicy);
		return enrolledPolicy.getInsuranceSchemeId();
	}


	private Date getMaturityDate(Date enrolledDate,int policyTerm) {
		Date currentDate=enrolledDate;
		Calendar cal=Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.YEAR, policyTerm);
		
		Date maturityDate=cal.getTime();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
		 String maturityStr=formatter.format(maturityDate);
		 
		 Date modifiedMaturityDate = null;
		try {
			modifiedMaturityDate = formatter.parse(maturityStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modifiedMaturityDate;
	}


	private Date getCurrentDate() {
		 Date currDate=new Date();
		 SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
		 String currDateStr=formatter.format(currDate);
		 Date modifiedDate = null;
		 try {
			modifiedDate=formatter.parse(currDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return modifiedDate;
	}


	@Override
	@Transactional
	public List<EnrolledPolicies> getEnrolledPolicies(int customerId) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from EnrolledPolicies where customer_id=:customerId");
		query.setParameter("customerId", customerId);
		List resultList = query.getResultList();
		return resultList;
		
	}


	@SuppressWarnings("deprecation")
	@Override
	public EnrolledPolicies getEnrolledPolicyById(int policyId) {
		 
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from EnrolledPolicies where id=:policyId");
		query.setParameter("policyId", policyId);
		List resultList = query.getResultList();
		EnrolledPolicies policy=null;
		if(resultList!=null)
			policy=(EnrolledPolicies) resultList.get(0);
		return policy;
	}


}

package com.monocept.insuranceapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.insuranceapp.dao.EnrolledPoliciesDao;
import com.monocept.insuranceapp.entity.Customer;
import com.monocept.insuranceapp.entity.EnrolledPolicies;

@Service
public class EnrolledPoliciesServiceImpl implements EnrolledPoliciesService {

	@Autowired
	EntityManager entityManager;
	@Autowired
	private EnrolledPoliciesDao enrolledPoliciesDao;
	
	
	@Override
	@Transactional
	public int buyPolicy(EnrolledPolicies enrolledPolicy, int customerId) {
		Date enrolledDate=getCurrentDate();
		Date maturityDate=getMaturityDate(enrolledDate,enrolledPolicy.getPolicyTerm());
		Session session = entityManager.unwrap(Session.class);
		Customer customer = session.get(Customer.class, customerId);
		enrolledPolicy.setSumAssured(enrolledPolicy.getInterestAmount()+enrolledPolicy.getInvestedAmount());
		enrolledPolicy.setEnrollDate(enrolledDate);
		enrolledPolicy.setMaturityDate(maturityDate);
		customer.enrollPolicy(enrolledPolicy);
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
		return maturityDate;
	}


	private Date getCurrentDate() {
		 Date currDate=new Date();
		 SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");
		 String currDateStr=formatter.format(currDate);
		 try {
			currDate=formatter.parse(currDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return currDate;
	}


}

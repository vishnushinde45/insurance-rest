package com.monocept.insuranceapp.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.insuranceapp.dao.InstallmentsDao;
import com.monocept.insuranceapp.entity.Customer;
import com.monocept.insuranceapp.entity.InstallmentPayments;
import com.monocept.insuranceapp.entity.Installments;

@Service
public class InstallmentsServiceImpl implements InstallmentsService {

	@Autowired
	private InstallmentsDao installmentDao;
	
	@Autowired
	EntityManager entityManager;

	@SuppressWarnings("deprecation")
	@Override
	public Installments getInstallment(int installmentId) {
		  Installments installments = installmentDao.getById(installmentId);
		return installments;
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional
	public void payInstallment(int customerId, int installmentId, String paymentType) {
		 Installments installments = installmentDao.getById(installmentId);
		 
		Session session = entityManager.unwrap(Session.class);
		Customer customer = session.get(Customer.class, customerId);
		InstallmentPayments installmentPayment=new InstallmentPayments(installments.getInstallmentAmount(), new Date(), customerId, customer.getFullName(), paymentType);
		installments.setStatus("PAID");
		installments.setTotalAmountPaid(installments.getTotalAmountPaid()+installments.getInstallmentAmount());
		session.saveOrUpdate(installmentPayment);
		session.saveOrUpdate(installments);
	}

	@Override
	@Transactional
	public List<InstallmentPayments> getInstallmentPayments() {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from InstallmentPayments");
		return query.getResultList();
		
	}

}

package com.monocept.insuranceapp.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.swing.text.DefaultEditorKit.CutAction;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monocept.insuranceapp.dao.CustomerDao;
import com.monocept.insuranceapp.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;


	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public int addCustomer(Customer customer) {
		
		return customerDao.addCustomer(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		customerDao.deleteCustomer(customerId);

	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		return customerDao.getCustomer(customerId);
	}

}

package com.monocept.insuranceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monocept.insuranceapp.dao.CustomerDao;
import com.monocept.insuranceapp.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		return customerDao.getCustomer(customerId);
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public Customer addCustomer(Customer customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	@Override
	@Transactional
	public Customer deleteCustomer(int customerId) {
		return customerDao.deleteCustomer(customerId);
	}

}

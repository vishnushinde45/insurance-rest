package com.monocept.insuranceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monocept.insuranceapp.dao.CustomerDao;
import com.monocept.insuranceapp.entity.Customer;
import com.monocept.insuranceapp.utility.ChangePassword;

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

	@Override
	@Transactional
	public Customer login(Customer customer) {
		return customerDao.login(customer);
	}

	@Override
	@Transactional
	public Customer getCustomerByUsername(String username) {
		
		return customerDao.getCustomerByUsername(username);
	}

	@Override
	@Transactional
	public Customer addCustomerByAgent(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.addCustomerByAgent(customer);
	}

	@Override
	@Transactional
	public void changePassword(ChangePassword passwordBody, int customerId) {
		customerDao.changePassword(passwordBody,customerId);
		
	}

	@Override
	@Transactional
	public void addDocument(int customerId,String documentType, String fileDownloadUri) {
		customerDao.addDocument(customerId,documentType,fileDownloadUri);
		
	}

	

}

package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.Customer;
import com.monocept.insuranceapp.utility.ChangePassword;

public interface CustomerService {
    
	Customer getCustomer(int customerId);
	List<Customer> getCustomers();
	Customer addCustomer(Customer customer);
	Customer updateCustomer(Customer customer);
	Customer deleteCustomer(int customerId);
	Customer login(Customer customer);
	Customer getCustomerByUsername(String username);
	Customer addCustomerByAgent(Customer customer);
	void changePassword(ChangePassword passwordBody, int customerId);
	void addDocument(int customerId, String documentType, String fileDownloadUri);
	
}

package com.monocept.insuranceapp.service;

import java.util.List;
import java.util.Optional;

import com.monocept.insuranceapp.entity.Customer;

public interface CustomerService {
	List<Customer> getCustomers();

	int addCustomer(Customer customer);

	void deleteCustomer(int customerId);

	Customer getCustomer(int customerId);
}

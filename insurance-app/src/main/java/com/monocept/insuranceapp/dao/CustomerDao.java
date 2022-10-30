package com.monocept.insuranceapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.insuranceapp.entity.Customer;

public interface CustomerDao {
	Customer getCustomer(int customerId);

	Customer deleteCustomer(int customerId);

	Customer addCustomer(Customer customer);

	List<Customer> getCustomers();

	Customer updateCustomer(Customer customer);

	Customer login(Customer customer);

	Customer getCustomerByUsername(String username);

}

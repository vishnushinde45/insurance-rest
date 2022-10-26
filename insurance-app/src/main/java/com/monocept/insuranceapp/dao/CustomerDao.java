package com.monocept.insuranceapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.insuranceapp.entity.Customer;

public interface CustomerDao {
	Customer getCustomer(int customerId);

	void deleteCustomer(int customerId);

	int addCustomer(Customer customer);

	List<Customer> getCustomers();

	int updateCustomer(Customer customer);
}

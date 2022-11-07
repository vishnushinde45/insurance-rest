package com.monocept.insuranceapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.insuranceapp.entity.Customer;
import com.monocept.insuranceapp.utility.ChangePassword;

public interface CustomerDao {
	Customer getCustomer(int customerId);

	Customer deleteCustomer(int customerId);

	Customer addCustomer(Customer customer);

	List<Customer> getCustomers();

	Customer updateCustomer(Customer customer);

	Customer login(Customer customer);

	Customer getCustomerByUsername(String username);

	Customer addCustomerByAgent(Customer customer);

	void changePassword(ChangePassword passwordBody, int customerId);

	void addDocument(int customerId, String documentType, String fileDownloadUri);

}

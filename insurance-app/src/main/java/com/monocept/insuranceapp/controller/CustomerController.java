package com.monocept.insuranceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.insuranceapp.entity.Customer;
import com.monocept.insuranceapp.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@RequestMapping("/")
	public List<Customer> getCustomers(){
		List<Customer> customers = service.getCustomers();
		return customers;
	}
   
}

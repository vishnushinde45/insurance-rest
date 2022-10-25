package com.monocept.insuranceapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.insuranceapp.entity.Customer;
import com.monocept.insuranceapp.service.CustomerService;

@RestController
@RequestMapping("/insurance")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		List<Customer> customers = service.getCustomers();
		return customers;
	}
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<?> getCustomer(@PathVariable int customerId) {
		if(service.getCustomer(customerId)==null) {
			 return new ResponseEntity<String>("Customer Not Found..",HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<Customer>(service.getCustomer(customerId),HttpStatus.OK);
		
	   
	}
	
	@PostMapping("/customers")
	public int addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		int id=service.addCustomer(customer);
		return id;
	}
	
	@PutMapping("/customers")
	public int updateCustomer(@RequestBody Customer customer) {
		int id=service.addCustomer(customer);
		return id;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		service.deleteCustomer(customerId);
		
	}
	
   
}

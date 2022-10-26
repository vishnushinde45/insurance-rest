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
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		List<Customer> customers = customerService.getCustomers();
		return customers;
	}
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<?> getCustomer(@PathVariable int customerId) {
		if(customerService.getCustomer(customerId)==null) {
			 return new ResponseEntity<String>("Customer Not Found..",HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<Customer>(customerService.getCustomer(customerId),HttpStatus.OK);
		
	   
	}
	
	@PostMapping("/customers")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		try {
			return new ResponseEntity<Integer>(customerService.addCustomer(customer),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/customers")
	public int updateCustomer(@RequestBody Customer customer) {
		int id=customerService.updateCustomer(customer);
		return id;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
		
	}
	
   
}

package com.monocept.insuranceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.monocept.insuranceapp.utility.ChangePassword;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		List<Customer> customers = customerService.getCustomers();
		return customers;
	}

	@GetMapping("/customers/{customerId}")
	public ResponseEntity<?> getCustomer(@PathVariable int customerId) {
		if (customerService.getCustomer(customerId) == null) {
			return new ResponseEntity<String>("Customer Not Found..", HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<Customer>(customerService.getCustomer(customerId), HttpStatus.OK);

	}

	@PostMapping("/customers")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		try {
			return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/customers/{agentId}")
	public ResponseEntity<?> addCustomerByAgent(@RequestBody Customer customer,@PathVariable int agentId) {
		customer.setId(0);
		customer.setAgentId(agentId);
		try {
			return new ResponseEntity<Customer>(customerService.addCustomerByAgent(customer), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		Customer cust = customerService.updateCustomer(customer);
		return cust;
	}

	@DeleteMapping("/customers/{customerId}")
	public Customer deleteCustomer(@PathVariable int customerId) {
		Customer customer = customerService.deleteCustomer(customerId);
		return customer;

	}
	
	@PostMapping("/customers/login")
	public ResponseEntity<?> login(@RequestBody Customer customer){
		Customer result=null;
		try {
			result=customerService.login(customer);
			System.out.println(result);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Customer>(result,HttpStatus.OK);
		
		
	}
	
	@PostMapping("/customers/change-password/{customerId}")
	public void changePassword(@RequestBody ChangePassword passwordBody,@PathVariable int customerId) {
		customerService.changePassword(passwordBody,customerId);
	}

}

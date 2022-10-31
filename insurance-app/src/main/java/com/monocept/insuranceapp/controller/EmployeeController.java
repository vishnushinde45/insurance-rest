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

import com.monocept.insuranceapp.entity.Employee;
import com.monocept.insuranceapp.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeController {
  
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<?> getCustomer(@PathVariable int employeeId) {
		if(employeeService.getEmployee(employeeId)==null) {
			 return new ResponseEntity<String>("Employee Not Found..",HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<Employee>(employeeService.getEmployee(employeeId),HttpStatus.OK);
		
	   
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee emp=employeeService.addEmployee(employee);
		return emp;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee emp=employeeService.updateEmployee(employee);
		return emp;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public Employee deleteCustomer(@PathVariable int employeeId) {
		Employee employee = employeeService.deleteEmployee(employeeId);
		return employee;
		
	}
	
	
}

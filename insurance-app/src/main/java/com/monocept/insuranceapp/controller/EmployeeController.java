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

import com.monocept.insuranceapp.entity.Agent;
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
	public ResponseEntity<?> getEmployee(@PathVariable int employeeId) {
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
	
	@PostMapping("/employees/login")
	public ResponseEntity<?> login(@RequestBody Employee employee) {
		Employee result = null;
		try {
			result=employeeService.login(employee);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Employee>(result,HttpStatus.OK);
	}
	
	
}

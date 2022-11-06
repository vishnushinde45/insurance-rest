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
import com.monocept.insuranceapp.entity.CommisionTransactions;
import com.monocept.insuranceapp.entity.Employee;
import com.monocept.insuranceapp.service.CommisionService;
import com.monocept.insuranceapp.service.CustomerService;
import com.monocept.insuranceapp.service.EmployeeService;
import com.monocept.insuranceapp.utility.ChangePassword;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeeController {
  
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CommisionService commisionService;
	
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
	
	@PostMapping("/employees/change-password/{employeeId}")
	public void changePassword(@RequestBody ChangePassword passwordBody,@PathVariable int employeeId) {
		employeeService.changePassword(passwordBody,employeeId);
	}
	
	@PostMapping("/employees/{adminId}")
	public Employee addEmployeeByAdmin(@RequestBody Employee employee,@PathVariable("adminId") int adminId) {
		Employee emp=employeeService.addEmployeeByAdmin(employee,adminId);
		return emp;
	}
	
	@GetMapping("/employees/commision-withdrawls")
	public List<CommisionTransactions> getCommisionWithdrawls(){
		List<CommisionTransactions> commisionWithdrawls=commisionService.getCommisionWithdrawls();
		return commisionWithdrawls;
	}
	
	
}

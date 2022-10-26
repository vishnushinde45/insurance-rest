package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.Customer;
import com.monocept.insuranceapp.entity.Employee;

public interface EmployeeService {
	List<Employee> getEmployees();

	int addEmployee(Employee employee);

	void deleteEmployee(int employeeId);

	Employee viewEmployeeById(int employeeId);

	void manageAgent(int agentId);

	void withdrawal();
	
	Employee getEmployee(int employeeId);

	

}

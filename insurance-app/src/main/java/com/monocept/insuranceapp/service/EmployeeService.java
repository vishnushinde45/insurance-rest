package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.Employee;

public interface EmployeeService {
	public List<Employee> getEmployees();

	public Employee addEmployee(Employee employee);

	public void deleteEmployee(int employeeId);

	public Employee viewEmployeeById(int employeeId);
	
	public void manageAgent(int agentId);
	
	public void withdrawal();
	
	
}

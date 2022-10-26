package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.Employee;

public interface EmployeeService {
	Employee getEmployee(int employeeId);
	List<Employee> getEmployees();
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee deleteEmployee(int employeeId);
}

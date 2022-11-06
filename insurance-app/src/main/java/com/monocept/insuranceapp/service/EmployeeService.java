package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.Employee;
import com.monocept.insuranceapp.utility.ChangePassword;

public interface EmployeeService {
	Employee getEmployee(int employeeId);
	List<Employee> getEmployees();
	
	Employee updateEmployee(Employee employee);
	Employee deleteEmployee(int employeeId);
	Employee login(Employee employee);
	void changePassword(ChangePassword passwordBody, int employeeId);
	Employee addEmployeeByAdmin(Employee employee, int adminId);
}

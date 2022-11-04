package com.monocept.insuranceapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.insuranceapp.entity.Customer;
import com.monocept.insuranceapp.entity.Employee;

public interface EmployeeDao {

	List<Employee> getEmployees();

	Employee getEmployee(int employeeId);

	Employee addEmployee(Employee employee);

	Employee deleteEmployee(int employeeId);

	Employee updateEmployee(Employee employee);

	Employee login(Employee employee);
    
}

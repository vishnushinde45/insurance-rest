package com.monocept.insuranceapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.insuranceapp.entity.Customer;
import com.monocept.insuranceapp.entity.Employee;

public interface EmployeeDao {

	List<Employee> getEmployees();

	Employee getEmployee(int employeeId);

	int addEmployee(Employee employee);

	void deleteEmployee(int employeeId);

	int updateEmployee(Employee employee);
    
}

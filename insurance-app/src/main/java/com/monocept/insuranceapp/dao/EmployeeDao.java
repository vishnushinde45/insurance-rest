package com.monocept.insuranceapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.insuranceapp.entity.Customer;
import com.monocept.insuranceapp.entity.Employee;
import com.monocept.insuranceapp.utility.ChangePassword;

public interface EmployeeDao {

	List<Employee> getEmployees();

	Employee getEmployee(int employeeId);


	Employee deleteEmployee(int employeeId);

	Employee updateEmployee(Employee employee);

	Employee login(Employee employee);

	void changePassword(ChangePassword passwordBody, int employeeId);

	Employee addEmployeeByAdmin(Employee employee, int adminId);
    
}

package com.monocept.insuranceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.monocept.insuranceapp.dao.EmployeeDao;
import com.monocept.insuranceapp.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional
	public Employee getEmployee(int employeeId) {
		return employeeDao.getEmployee(employeeId);
	}

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	@Transactional
	public Employee addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	@Override
	@Transactional
	public Employee deleteEmployee(int employeeId) {
		return employeeDao.deleteEmployee(employeeId);
	}

	
}

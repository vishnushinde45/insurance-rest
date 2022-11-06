package com.monocept.insuranceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monocept.insuranceapp.dao.EmployeeDao;
import com.monocept.insuranceapp.entity.Employee;
import com.monocept.insuranceapp.utility.ChangePassword;

@Service
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
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	@Override
	@Transactional
	public Employee deleteEmployee(int employeeId) {
		return employeeDao.deleteEmployee(employeeId);
	}

	@Override
	@Transactional
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.login(employee);
	}

	@Override
	@Transactional
	public void changePassword(ChangePassword passwordBody, int employeeId) {
		employeeDao.changePassword(passwordBody,employeeId);
		
	}

	@Override
	@Transactional
	public Employee addEmployeeByAdmin(Employee employee, int adminId) {
		Employee emp=employeeDao.addEmployeeByAdmin(employee,adminId);
		return emp;
	}

	
}

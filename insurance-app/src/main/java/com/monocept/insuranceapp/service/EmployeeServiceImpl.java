package com.monocept.insuranceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.monocept.insuranceapp.dao.EmployeeDao;
import com.monocept.insuranceapp.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	@Transactional
	public int addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int employeeId) {
		employeeDao.deleteEmployee(employeeId);
    
	}

	@Override
	public void manageAgent(int agentId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee viewEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Employee> getEmployees() {

		return employeeDao.getEmployees();
	}

	@Override
	public void withdrawal() {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public Employee getEmployee(int employeeId) {
		return employeeDao.getEmployee(employeeId);
	}

	@Override
	@Transactional
	public int updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

}

package com.monocept.insuranceapp.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.insuranceapp.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Employee> getEmployees() {
		Session session = entityManager.unwrap(Session.class);
		List resultList = session.createQuery("from Employee").getResultList();
		return resultList;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		Session session = entityManager.unwrap(Session.class);

		return session.get(Employee.class, employeeId);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		if(checkUserIsAlreadyExist(employee)) {
			throw new RuntimeException("Employee is Already Exist..");
		}else {
			employee.setPassword(this.generatePassword());
			session.saveOrUpdate(employee);
			
		}
		
		return employee;
	}
	
	public boolean checkUserIsAlreadyExist(Employee employee) {
		List<Employee> employees = this.getEmployees();
		return employees.stream().anyMatch(emp->emp.getUsername().equalsIgnoreCase(employee.getUsername()));
		 
	}

	@Override
	public Employee deleteEmployee(int employeeId) {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = session.get(Employee.class, employeeId);
		session.delete(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		return employee;

	}
	public String generatePassword() {
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}


}

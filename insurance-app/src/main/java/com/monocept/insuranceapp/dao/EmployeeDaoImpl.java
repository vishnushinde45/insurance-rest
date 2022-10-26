package com.monocept.insuranceapp.dao;

import java.util.List;

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
	public int addEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		return employee.getId();
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = session.get(Employee.class, employeeId);
		session.delete(employee);
	}

}

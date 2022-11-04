package com.monocept.insuranceapp.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import com.monocept.insuranceapp.email.EmailSenderService;
import com.monocept.insuranceapp.entity.Admin;
import com.monocept.insuranceapp.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	EntityManager entityManager;
	
	@Autowired
	private EmailSenderService senderService;
	
	@EventListener(ApplicationReadyEvent.class)
	
		
	

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
			String mail=employee.getEmailId();
			String subject="Successfull Registration on Sun Insurance System!";
			String body="You are Registered Successfully, Your Username is: "+employee.getUsername()+" and password is : "+employee.getPassword();
			senderService.sendEmail(mail, subject, body);
			
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

	@Override
	public Employee login(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		boolean isAuthenticated=authenticate(employee);
		Employee result=null;
		if(isAuthenticated)
			result=this.getByUsername(employee.getUsername());
		else
			throw new RuntimeException("Invalid Employee Details");
		
		return result;
	}
	
	private boolean authenticate(Employee employee) {
		Employee emp=this.getByUsername(employee.getUsername());
		if(employee.getUsername().equals(emp.getUsername()) && employee.getPassword().equals(emp.getPassword()))
			return true;
		if(emp==null)
			return false;
		return false;
	}
	
	public Employee getByUsername(String username) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Employee where username=:userName");
		query.setParameter("userName", username);
		List resultList = query.getResultList();
		if(resultList!=null)
			return (Employee) resultList.get(0);
		return null;
	}



}

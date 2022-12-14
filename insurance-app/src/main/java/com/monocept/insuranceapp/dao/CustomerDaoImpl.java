package com.monocept.insuranceapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.insuranceapp.entity.Agent;
import com.monocept.insuranceapp.entity.Commision;
import com.monocept.insuranceapp.entity.Customer;
import com.monocept.insuranceapp.entity.Documents;
import com.monocept.insuranceapp.utility.ChangePassword;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    
	@Autowired
	EntityManager entityManager;
  
	@Override
	public Customer getCustomer(int customerId) {
		Session session = entityManager.unwrap(Session.class);
		Customer customer = session.get(Customer.class, customerId);
		return customer;
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		Session session = entityManager.unwrap(Session.class);
		Customer customer = session.get(Customer.class, customerId);
		session.delete(customer);
		return customer;
		
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		boolean isAlreadyExist=this.checkUserIsAlreadyExist(customer);
		if(isAlreadyExist) {
			throw new RuntimeException("Customer is already Exists");
		}else {
			session.saveOrUpdate(customer);
		}
		
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {
		Session session = entityManager.unwrap(Session.class);
		List resultList = session.createQuery("from Customer").getResultList();
		return resultList;
	}
	
	public boolean checkUserIsAlreadyExist(Customer customer) {
		List<Customer> customers = this.getCustomers();
		return customers.stream().anyMatch(cust->cust.getUsername().equalsIgnoreCase(customer.getUsername()));
		 
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(customer);
		return customer;
	}

	@Override
	public Customer login(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		boolean isAuthenticated=authenticate(customer);
		if(isAuthenticated)
			customer=this.getCustomerByUsername(customer.getUsername());
		else
			throw new RuntimeException("Invalid Customer Details");
		
		return customer;
	}

	private boolean authenticate(Customer customer) {
		
		Customer cust=this.getCustomerByUsername(customer.getUsername());
		if(customer.getUsername().equals(cust.getUsername()) && customer.getPassword().equals(cust.getPassword()))
			return true;
		if(cust==null)
			return false;
		return false;
		
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Customer where username=:userName");
		query.setParameter("userName", username);
		List resultList = query.getResultList();
		if(resultList!=null)
			return (Customer) resultList.get(0);
		return null;
	}

	@Override
	public Customer addCustomerByAgent(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		boolean isAlreadyExist=this.checkUserIsAlreadyExist(customer);
		if(isAlreadyExist) {
			throw new RuntimeException("Customer is already Exists");
		}else {
			session.saveOrUpdate(customer);
		}
		
		return customer;
	}

	@Override
	public void changePassword(ChangePassword passwordBody, int customerId) {
		 Session session = entityManager.unwrap(Session.class);
		 Customer customer = session.get(Customer.class, customerId);
		 
		 if(customer.getPassword().equals(passwordBody.getOldPassword())) {
			 customer.setPassword(passwordBody.getNewPassword());
			 session.saveOrUpdate(customer);
		 }
		 else {
		     throw new RuntimeException("Password did not matched, please try again");
		 }
		
	}



	@Override
	public void addDocument(int customerId, String documentType, String fileDownloadUri) {
		Session session = entityManager.unwrap(Session.class);
		Customer customer = session.get(Customer.class, customerId);
		
	    customer.addDocument(documentType,fileDownloadUri);
		session.saveOrUpdate(customer);
	}

	

}

package com.monocept.insuranceapp.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.monocept.insuranceapp.entity.Customer;

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
	public void deleteCustomer(int customerId) {
		Session session = entityManager.unwrap(Session.class);
		Customer customer = session.get(Customer.class, customerId);
		session.delete(customer);
		
	}

	@Override
	public int addCustomer(Customer customer) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(customer);
		return customer.getId();
	}

	@Override
	public List<Customer> getCustomers() {
		Session session = entityManager.unwrap(Session.class);
		List resultList = session.createQuery("from Customer").getResultList();
		return resultList;
	}

}

package com.monocept.insuranceapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.insuranceapp.entity.Customer;


	public interface EmployeeDao extends JpaRepository<Customer, Integer> {

	}



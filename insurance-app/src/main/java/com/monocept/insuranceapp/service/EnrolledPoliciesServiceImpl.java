package com.monocept.insuranceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.insuranceapp.dao.EnrolledPoliciesDao;

@Service
public class EnrolledPoliciesServiceImpl implements EnrolledPoliciesService {

	@Autowired
	private EnrolledPoliciesDao enrolledPoliciesDao;
}

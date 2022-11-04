package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.EnrolledPolicies;

public interface EnrolledPoliciesService {


	int buyPolicy(EnrolledPolicies enrolledPolicy, int customerId);

	List<EnrolledPolicies> getEnrolledPolicies(int customerId);

	EnrolledPolicies getEnrolledPolicyById(int policyId);

}

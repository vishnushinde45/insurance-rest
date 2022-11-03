package com.monocept.insuranceapp.service;

import com.monocept.insuranceapp.entity.EnrolledPolicies;

public interface EnrolledPoliciesService {


	int buyPolicy(EnrolledPolicies enrolledPolicy, int customerId);

}

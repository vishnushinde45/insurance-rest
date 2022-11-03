package com.monocept.insuranceapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monocept.insuranceapp.entity.EnrolledPolicies;

@Repository
public interface EnrolledPoliciesDao extends JpaRepository<EnrolledPolicies, Integer>{

}

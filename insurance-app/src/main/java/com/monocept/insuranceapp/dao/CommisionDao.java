package com.monocept.insuranceapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monocept.insuranceapp.entity.Commision;

@Repository
public interface CommisionDao extends JpaRepository<Commision, Integer>{

}

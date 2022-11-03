package com.monocept.insuranceapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monocept.insuranceapp.entity.Installments;

@Repository
public interface InstallmentsDao extends JpaRepository<Installments, Integer>{

}

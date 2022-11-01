package com.monocept.insuranceapp.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.monocept.insuranceapp.entity.InsuranceSettings;

@Service
public interface InsuranceSettingsService extends JpaRepository<InsuranceSettings, Integer> {

}

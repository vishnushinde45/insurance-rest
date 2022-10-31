package com.monocept.insuranceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.monocept.insuranceapp.entity.InsurancePlan;
import com.monocept.insuranceapp.service.InsurancePlanService;

@RestController
@RequestMapping("/api")
public class InsurancePlanController {

	@Autowired
	private InsurancePlanService insurancePlanService;

	@GetMapping("/InsurancePlan")
	public List<InsurancePlan> getInsurancePlans() {
		List<InsurancePlan> insurancePlans = insurancePlanService.getInsurancePlan();
		return insurancePlans;
	}

	@GetMapping("/insurancePlan/{planId}")
	public ResponseEntity<?> getInsurancePlan(@PathVariable int planId) {
		if (insurancePlanService.getInsurancePlan(planId) == null) {
			return new ResponseEntity<String>("Agent Not Found..", HttpStatus.BAD_REQUEST);

		}
		return new ResponseEntity<InsurancePlan>(insurancePlanService.getInsurancePlan(planId), HttpStatus.OK);

	}

	@PostMapping("/insurancePlan")
	public ResponseEntity<?> addInsurancePlan(@RequestBody InsurancePlan insurancePlan) {
		insurancePlan.setId(0);
		try {
			return new ResponseEntity<InsurancePlan>(insurancePlanService.addInsurancePlan(insurancePlan),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/insurancePlan")
	public InsurancePlan updateAgent(@RequestBody InsurancePlan insurancePlan) {
		InsurancePlan insurancePln = insurancePlanService.updateInsurancePlan(insurancePlan);
		return insurancePln;

	}

	@DeleteMapping("/insurancePlan/{planId}")
	public InsurancePlan deleteInsurancePlan(@PathVariable int planId) {
		InsurancePlan insurancePlan = insurancePlanService.deleteInsurancePlan(planId);
		return insurancePlan;

	}

}

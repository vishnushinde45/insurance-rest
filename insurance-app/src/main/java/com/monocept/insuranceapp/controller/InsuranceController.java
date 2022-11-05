package com.monocept.insuranceapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.insuranceapp.entity.EnrolledPolicies;
import com.monocept.insuranceapp.entity.InstallmentPayments;
import com.monocept.insuranceapp.entity.Installments;
import com.monocept.insuranceapp.entity.InsurancePlan;
import com.monocept.insuranceapp.entity.InsuranceScheme;
import com.monocept.insuranceapp.entity.InsuranceSettings;
import com.monocept.insuranceapp.entity.InsuranceType;
import com.monocept.insuranceapp.service.EnrolledPoliciesService;
import com.monocept.insuranceapp.service.InstallmentsService;
import com.monocept.insuranceapp.service.InsurancePlanService;
import com.monocept.insuranceapp.service.InsuranceSchemeService;
import com.monocept.insuranceapp.service.InsuranceSettingsService;
import com.monocept.insuranceapp.service.InsuranceTypeService;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class InsuranceController {


	@Autowired
	private InsuranceTypeService insuranceTypeService;

	@Autowired
	private InsuranceSchemeService insuranceSchemeService;

	@Autowired
	private InsurancePlanService insurancePlanService;

	@Autowired
	private InsuranceSettingsService insuranceSettingService;

	@Autowired
	private EnrolledPoliciesService enrolledPoliciesService;
	
	@Autowired
	private InstallmentsService installmentsService;


	@GetMapping("/insurance-type")
	public List<InsuranceType> getInsuranceTypes() {
		List<InsuranceType> insuranceTypes = insuranceTypeService.getInsuranceTypes();

		return insuranceTypes;

	}

	@PostMapping("/insurance-type")
	public ResponseEntity<?> addInsuranceType(@RequestBody InsuranceType insuranceType) {
		InsuranceType result = insuranceTypeService.addInsuranceType(insuranceType);
		return new ResponseEntity<InsuranceType>(result, HttpStatus.OK);

	}

	@PostMapping("/insurance-scheme/{insuranceTypeId}")
	public ResponseEntity<String> addInsuranceScheme(@RequestBody InsuranceScheme insuranceScheme,
			@PathVariable("insuranceTypeId") int id) {

		InsuranceScheme insuScheme = insuranceSchemeService.addInsuranceScheme(insuranceScheme, id);
		if (insuScheme == null)
			return new ResponseEntity<String>("unable to add scheme", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<String>("Scheme Added successfully", HttpStatus.OK);
	}

	@GetMapping("/insurance-scheme")
	public List<InsuranceScheme> getInsuranceSchemes() {
		List<InsuranceScheme> schemes = insuranceSchemeService.getInsuranceSchemes();
		return schemes;
	}

	@GetMapping("/insurance-scheme/{insuranceTypeId}")
	public List<InsuranceScheme> getInsuranceSchemesByTypeId(@PathVariable("insuranceTypeId") int insuranceTypeId) {
		List<InsuranceScheme> schemes = insuranceSchemeService.getInsuranceSchemesByTypeId(insuranceTypeId);
		return schemes;
	}

	@PostMapping("/insurance-plan/{insuranceTypeId}/{insuranceSchemeId}")
	public ResponseEntity<?> addInsurancePlan(@RequestBody InsurancePlan insurancePlan,
			@PathVariable("insuranceTypeId") int insuranceTypeId,
			@PathVariable("insuranceSchemeId") int insuranceSchemeId) {

		insurancePlanService.addInsurancePlan(insurancePlan, insuranceTypeId, insuranceSchemeId);
		return new ResponseEntity<String>("Plan Added", HttpStatus.OK);
	}

	@PostMapping("/insurance-tax-deduction")
	public ResponseEntity<?> addInsuranceTax(@RequestBody InsuranceSettings insuranceSettings) {
		InsuranceSettings setting = insuranceSettingService.save(insuranceSettings);
		return new ResponseEntity<String>("Tax Added", HttpStatus.OK);
	}

	@GetMapping("/insurance-plan")
	public List<InsurancePlan> getInsurancePlans() {
		List<InsurancePlan> plans = insurancePlanService.getInsurancePlans();
		return plans;
	}

	@GetMapping("/insurance-plan/{id}")
	public InsurancePlan getInsurancePlan(@PathVariable("id") int id) {
		InsurancePlan plan = insurancePlanService.getInsurancePlan(id);
		return plan;
	}

	@PostMapping("/insurance/buy-policy/{customerId}/{schemeId}")
	public int buyPolicy(@RequestBody EnrolledPolicies enrolledPolicy, @PathVariable("customerId") int customerId,
			@PathVariable("schemeId") int schemeId) {
		enrolledPolicy.setInsuranceSchemeId(schemeId);
		System.out.println(enrolledPolicy);
		int enrolledId = enrolledPoliciesService.buyPolicy(enrolledPolicy, customerId);
		return enrolledId;
	}

	@GetMapping("/enrolled-policies/{customerId}")
	public List<EnrolledPolicies> getEnrolledPolicies(@PathVariable("customerId") int customerId) {
		List<EnrolledPolicies> policies = enrolledPoliciesService.getEnrolledPolicies(customerId);
		return policies;

	}
	
	@GetMapping("/enrolled-policy/{policyId}")
	public EnrolledPolicies getEnrolledPolicyById(@PathVariable("policyId") int policyId) {
		EnrolledPolicies policy=enrolledPoliciesService.getEnrolledPolicyById(policyId);
		return policy;
	}
	
	@PostMapping("/pay-installment/{customerId}/{installmentId}/{paymentType}")
	public void payInstallment(@PathVariable("customerId") int customerId,@PathVariable("installmentId") int installmentId,
			@PathVariable("paymentType") String paymentType) {
		installmentsService.payInstallment(customerId,installmentId,paymentType);
	}
	
	@GetMapping("/view-policy-payments")
	public List<InstallmentPayments> getInstallmentPayments(){
		return installmentsService.getInstallmentPayments();
	}
}

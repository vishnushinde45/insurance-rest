package com.monocept.insuranceapp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.monocept.insuranceapp.entity.InsurancePlan;
import com.monocept.insuranceapp.image.ImageRepository;
import com.monocept.insuranceapp.image.ImageService;
import com.monocept.insuranceapp.image.SchemeImage;
import com.monocept.insuranceapp.service.InsurancePlanService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class InsuranceController {

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private ImageService imageService;

	@Autowired
	private InsurancePlanService insurancePlanService;

	@PostMapping("/upload")
	public ResponseEntity<String> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {

		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		SchemeImage img = new SchemeImage(file.getOriginalFilename(), file.getContentType(),
				imageService.compressBytes(file.getBytes()));
		imageRepository.save(img);
		return new ResponseEntity<String>("Uploaded", HttpStatus.OK);
	}

	@GetMapping(path = { "/get/{imageName}" })
	public SchemeImage getImage(@PathVariable("imageName") String imageName) throws IOException {

		final Optional<SchemeImage> retrievedImage = imageRepository.findByName(imageName);
		SchemeImage img = new SchemeImage(retrievedImage.get().getName(), retrievedImage.get().getType(),
				imageService.decompressBytes(retrievedImage.get().getPicByte()));
		return img;
	}

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

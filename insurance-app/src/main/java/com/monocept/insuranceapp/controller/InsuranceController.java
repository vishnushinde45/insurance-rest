package com.monocept.insuranceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.insuranceapp.image.ImageStorageService;

@RestController
@RequestMapping("/api")
public class InsuranceController {
	@Autowired
	private ImageStorageService imageService;

	

}

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

import com.monocept.insuranceapp.entity.Admin;
import com.monocept.insuranceapp.service.AdminService;
import com.monocept.insuranceapp.service.AdminServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/admin")
	public List<Admin> getAdmins() {
		return adminService.getAdmins();
	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<?> getAdmin(@PathVariable int id) {
		Admin admin = adminService.getAdmin(id);
		if(admin==null)
			return new ResponseEntity<String>("Admin Not FOund",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Admin>(admin,HttpStatus.OK);
	}


	@PostMapping("/admin/login")
	public ResponseEntity<?> login(@RequestBody Admin admin) {
		Admin result = null;
		try {
			result=adminService.login(admin);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Admin>(result,HttpStatus.OK);
	}
	

}

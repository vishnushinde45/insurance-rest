package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.Admin;

public interface AdminService{


	Admin login(Admin admin);

	List<Admin> getAdmins();

	Admin getAdmin(int id);



}

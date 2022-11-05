package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.Admin;
import com.monocept.insuranceapp.utility.ChangePassword;

public interface AdminService{


	Admin login(Admin admin);

	List<Admin> getAdmins();

	Admin getAdmin(int id);

	void changePassword(ChangePassword passwordBody, int adminId);



}

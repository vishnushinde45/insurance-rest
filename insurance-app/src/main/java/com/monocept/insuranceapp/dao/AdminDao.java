package com.monocept.insuranceapp.dao;

import java.util.List;

import com.monocept.insuranceapp.entity.Admin;
import com.monocept.insuranceapp.utility.ChangePassword;

public interface AdminDao {

	Admin getByUsername(String username);

	Admin login(Admin admin);

	List<Admin> getAdmins();

	Admin getAdmin(int id);

	void changePassword(ChangePassword passwordBody, int adminId);



}

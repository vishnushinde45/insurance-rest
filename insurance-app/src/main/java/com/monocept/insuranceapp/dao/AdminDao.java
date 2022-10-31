package com.monocept.insuranceapp.dao;

import java.util.List;

import com.monocept.insuranceapp.entity.Admin;

public interface AdminDao {

	Admin getByUsername(String username);

	Admin login(Admin admin);

	List<Admin> getAdmins();

	Admin getAdmin(int id);



}

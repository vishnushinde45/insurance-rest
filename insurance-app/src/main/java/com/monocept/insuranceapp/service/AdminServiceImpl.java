package com.monocept.insuranceapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.insuranceapp.dao.AdminDao;
import com.monocept.insuranceapp.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
    private AdminDao adminDao;

	@Override
	@Transactional
	public Admin login(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.login(admin);
	}

	@Override
	@Transactional
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return adminDao.getAdmins();
	}

	@Override
	@Transactional
	public Admin getAdmin(int id) {
		// TODO Auto-generated method stub
		return adminDao.getAdmin(id);
	}

	



	

}

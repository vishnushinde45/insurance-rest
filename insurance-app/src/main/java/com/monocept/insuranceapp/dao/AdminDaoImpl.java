package com.monocept.insuranceapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.insuranceapp.entity.Admin;
import com.monocept.insuranceapp.entity.Agent;
import com.monocept.insuranceapp.utility.ChangePassword;

@Repository
public class AdminDaoImpl implements AdminDao {
	@Autowired
	EntityManager entityManager;

	@Override
	public Admin getByUsername(String username) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Admin where username=:userName");
		query.setParameter("userName", username);
		List resultList = query.getResultList();
		if(resultList!=null)
			return (Admin) resultList.get(0);
		return null;
	}

	@Override
	public Admin login(Admin admin) {
		Session session = entityManager.unwrap(Session.class);
		boolean isAuthenticated=authenticate(admin);
		Admin result=null;
		if(isAuthenticated)
			result=this.getByUsername(admin.getUsername());
		else
			throw new RuntimeException("Invalid Admin Details");
		
		return result;
		
	}

	private boolean authenticate(Admin admin) {
		Admin adm=this.getByUsername(admin.getUsername());
		if(admin.getUsername().equals(adm.getUsername()) && admin.getPassword().equals(adm.getPassword()))
			return true;
		if(adm==null)
			return false;
		return false;
	}

	@Override
	public List<Admin> getAdmins() {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("from Admin").getResultList();
	}

	@Override
	public Admin getAdmin(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from Admin where id=:id");
		query.setParameter("id", id);
		List resultList = query.getResultList();
		if(resultList!=null)
			return (Admin) resultList.get(0);
		return null;
		
	}

	@Override
	public void changePassword(ChangePassword passwordBody, int adminId) {
		 Session session = entityManager.unwrap(Session.class);
		 Admin admin = session.get(Admin.class, adminId);
		 
		 if(admin.getPassword().equals(passwordBody.getOldPassword())) {
			 admin.setPassword(passwordBody.getNewPassword());
			 session.saveOrUpdate(admin);
		 }
		 else {
		     throw new RuntimeException("Password did not matched, please try again");
		 }
		
	}

	
	

}

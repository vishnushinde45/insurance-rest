package com.monocept.insuranceapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.insuranceapp.dao.CommisionDao;

@Service
public class CommisionServiceImpl implements CommisonService {

	@Autowired
	private CommisionDao commisionDao;
	
}

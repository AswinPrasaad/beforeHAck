package com.mockathon.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockathon.Dao.DaoIntf;
import com.mockathon.modelPojo.Users;


@Service
public class ServiceImpl implements ServiceIntf {

	
	
	@Autowired
	DaoIntf dao;
	
	@Override
	public void save(Users user) {
	dao.save(user);
		
	}


}

package com.mockathon.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mockathon.modelPojo.Users;


public interface DaoIntf extends CrudRepository<Users, Integer> {

	
/*
	List<User> deleteByUserId(int id);

	

	List<User> findAllByUserName(String name);
*/
	

	



}

package com.cognizant.authorizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.authorizationservice.model.MyUser;

/*
 * This is a Repository for the authentication
*/
@Repository
public interface UserRepository extends JpaRepository<MyUser,String > {
	
	/**
	 * @param username
	 * returns username by username from database
	 */ 
	public MyUser findByUsername(String username);

	

}

package com.nick.ClientCaseData.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nick.ClientCaseData.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	//find all users
	List<User> findAll();
	//takes in an email and if it exits we get a true, if someone hasn't registered we get a false
	boolean existsByEmail(String email);
	//login authentication
	User findByEmail(String email);
}


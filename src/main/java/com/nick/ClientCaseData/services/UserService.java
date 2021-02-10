package com.nick.ClientCaseData.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nick.ClientCaseData.models.User;
import com.nick.ClientCaseData.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User findUser(Long id) {
		User user = this.userRepo.findById(id).orElse(null);
		return user;
	}
	
	public List<User> getAllUsers(){
		return this.userRepo.findAll();
	}
	
	public User registerUser(User newUser) {
		String hash = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hash);
		return this.userRepo.save(newUser);
	}
	
	//Login Authentication
	public boolean authenticateUser(String email, String password) {
		User user = this.userRepo.findByEmail(email);
		if(user == null) {
			return false;
		}
	
		return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.userRepo.findByEmail(email);
	}
}
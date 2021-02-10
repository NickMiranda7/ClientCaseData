package com.nick.ClientCaseData.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.nick.ClientCaseData.models.User;
import com.nick.ClientCaseData.repositories.UserRepository;

@Component
public class Validator {

	@Autowired
	private UserRepository userRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
	        User user = (User) target;
	        

	        if(!user.getPassword().equals(user.getConfirmPassword())) {
	        	errors.rejectValue("password", "match", "Passwords need to match!");
	        }
	        
	        
	        // Make sure email is unique in the database
	        if(this.userRepo.existsByEmail(user.getEmail())) {
	        	errors.rejectValue("email", "Unique", "Email is already taken!");
	        }
	        
	        
	    }
}
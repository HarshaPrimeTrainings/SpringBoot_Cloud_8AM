package com.training.springsecuritybasicauth.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.springsecuritybasicauth.dao.UserRepository;
import com.training.springsecuritybasicauth.dao.Users;

@RestController
public class UserController {

	@Autowired
	UserRepository repo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@PostMapping("/signin")
	public Users save(@RequestBody Users u) {
		u.setPassword(encoder.encode(u.getPassword()));
		return repo.save(u);
	}
	
	
}

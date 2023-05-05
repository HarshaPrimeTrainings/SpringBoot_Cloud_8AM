package com.training.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.model.User;
import com.training.userservice.service.UsersService;

@RestController
public class UserController {

	@Autowired
	UsersService service;
	
	@GetMapping("/greet")
	public ResponseEntity<String>  greet(String name) {
		return new ResponseEntity<String>("Hello There !!", HttpStatus.OK);
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(service.getUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable int uid) {
		return new ResponseEntity<User>(service.getUserById(uid), HttpStatus.OK);
	}
	
	@GetMapping("/username/{uname}")
	public ResponseEntity<User> getUserByName(@PathVariable String uname ) {
		return new ResponseEntity<User>(service.getUserByName(uname),HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> insertUser(@RequestBody User usr) {
		return new ResponseEntity<User>(service.insertUser(usr), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{uid}")
	public ResponseEntity<User> updateUser(@PathVariable int uid,@RequestBody User usr) {
		return new ResponseEntity<User>(service.updateUser(uid, usr),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable int uid) {
		return new ResponseEntity<String>(service.deleteUser(uid), HttpStatus.ACCEPTED);
	}
	
}

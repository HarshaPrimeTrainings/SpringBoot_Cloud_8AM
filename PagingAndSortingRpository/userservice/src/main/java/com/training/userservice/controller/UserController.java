package com.training.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
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
	

	@GetMapping(value="/greet",produces = MediaType.TEXT_PLAIN_VALUE )
	public ResponseEntity<String>  greet(String name) {
		
		return new ResponseEntity<String>("<h1>Hello There !!</h1>", HttpStatus.OK);
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<List<User>>(service.getUsers(), HttpStatus.OK);
	}

	@GetMapping("/userpage/{pageSize}/{pageNo}")
	public ResponseEntity<List<User>> getUsersByPage(@PathVariable int pageSize,@PathVariable int pageNo){
		return new ResponseEntity<List<User>>(service.getUsersByPage(pageNo, pageSize),HttpStatus.OK);
	}
	
	@GetMapping("/usersort/{sort}/{asc}")
	public ResponseEntity<List<User>> getUsersBySort(@PathVariable String sort, @PathVariable String asc){
		return new ResponseEntity<List<User>>(service.getUserBySort(sort,asc),HttpStatus.OK);
	}
	
	
	@GetMapping("/user/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable int uid) {
		return new ResponseEntity<User>(service.getUserById(uid), HttpStatus.OK);
	}
	
	@GetMapping("/username/{uname}")
	public ResponseEntity<User> getUserByName(@PathVariable String uname ) {
		return new ResponseEntity<User>(service.getUserByName(uname),HttpStatus.OK);
	}
	
	@GetMapping("/addr/{addr}")
	public ResponseEntity<List<User>> getUserByAddr(@PathVariable String addr ) {
		return new ResponseEntity<List<User>>(service.getUserByaddr(addr),HttpStatus.OK);
	}
	
	@GetMapping("/unameaddr/{uname}/{id}")
	public ResponseEntity<User> getUserByNameAndAddr(@PathVariable String uname,@PathVariable Integer id) {
		return new ResponseEntity<User>(service.getunameandaddr(uname,id),HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
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

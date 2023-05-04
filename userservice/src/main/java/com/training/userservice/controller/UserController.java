package com.training.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.userservice.model.User;

@RestController
public class UserController {

	List<User> ul = new ArrayList<>();
	
	public UserController() {
		ul.add(new User(1, "Joe", "Hyd"));
		ul.add(new User(2, "Monika", "Bang"));
		ul.add(new User(3, "Pheebe", "Channai"));
		ul.add(new User(4, "Rachel", "Pune"));
		ul.add(new User(5, "Chandler", "BMBY"));
		ul.add(new User(6, "Ross", "KLKT"));
	}
	
	@RequestMapping("/greet")
	public String greet(String name) {
		return "Hello There !!";
	}
	
	@RequestMapping("/users")
	public List<User> getUsers(){
		return ul;
		
	}
	
	@RequestMapping("/user/{uid}")
	public User getUserById(@PathVariable int uid) {
		return ul.stream().filter(u->u.getUid()==uid)
		.findFirst().orElseThrow(()->new RuntimeException("User not found with id: "+ uid));
	}
	
	@RequestMapping("/username/{uname}")
	public User getUserByName(@PathVariable String uname ) {
		return ul.stream().filter(u->u.getUname().equalsIgnoreCase(uname))
		.findFirst().orElseThrow(()->new RuntimeException("User not found with name: "+ uname));
	}
	
	@RequestMapping(value = "/save" ,method = RequestMethod.POST)
	public User insertUser(@RequestBody User usr) {
		ul.add(usr);
		return ul.stream().filter(u->u.getUid()==usr.getUid())
				.findFirst().orElseThrow(()->new RuntimeException("Unable to save User"));
	}
	
	@RequestMapping(value = "/update/{uid}",method = RequestMethod.PUT)
	public User updateUser(@PathVariable int uid,@RequestBody User usr) {
	User existing	= ul.stream().filter(u->u.getUid()==uid)
			.findFirst().orElseThrow(()->new RuntimeException("User not found with id: "+ uid));
		
		if(usr.getUname()!=null)
			existing.setUname(usr.getUname());
		if(usr.getAddr()!=null)
			existing.setAddr(usr.getAddr());
		return existing;
	}
	
	@RequestMapping(value = "/delete/{uid}",method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable int uid) {
		User existing	= ul.stream().filter(u->u.getUid()==uid)
				.findFirst().orElseThrow(()->new RuntimeException("User not found with id: "+ uid));
		ul.remove(existing);
		return "User Deleted with ID :: "+ uid;
	}
	
}

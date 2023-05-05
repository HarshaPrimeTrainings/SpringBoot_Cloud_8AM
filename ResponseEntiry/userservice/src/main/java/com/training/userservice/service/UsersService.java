package com.training.userservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.userservice.exceptions.UserNotFoundException;
import com.training.userservice.model.User;

@Service
public class UsersService {
	
List<User> ul = new ArrayList<>();
	
	public UsersService() {
		ul.add(new User(1, "Joe", "Hyd"));
		ul.add(new User(2, "Monika", "Bang"));
		ul.add(new User(3, "Pheebe", "Channai"));
		ul.add(new User(4, "Rachel", "Pune"));
		ul.add(new User(5, "Chandler", "BMBY"));
		ul.add(new User(6, "Ross", "KLKT"));
	}
	
	
	public List<User> getUsers(){
		return ul;
	}
	
	public User getUserById(int uid) {
		return ul.stream().filter(u->u.getUid()==uid)
		.findFirst().orElseThrow(()->new UserNotFoundException("User not found with id: "+ uid));
	}
	
	public User getUserByName(String uname ) {
		return ul.stream().filter(u->u.getUname().equalsIgnoreCase(uname))
		.findFirst().orElseThrow(()->new UserNotFoundException("User not found with name: "+ uname));
	}

	public User insertUser(User usr) {
		ul.add(usr);
		return this.getUserById(usr.getUid());
	}
	
	public User updateUser(int uid,User usr) {
		User existing	= this.getUserById(uid);
			if(usr.getUname()!=null)
				existing.setUname(usr.getUname());
			if(usr.getAddr()!=null)
				existing.setAddr(usr.getAddr());
			return existing;
		}
	
	public String deleteUser(int uid) {
		User existing	= this.getUserById(uid);
		ul.remove(existing);
		return "User Deleted with ID :: "+ uid;
	}
}

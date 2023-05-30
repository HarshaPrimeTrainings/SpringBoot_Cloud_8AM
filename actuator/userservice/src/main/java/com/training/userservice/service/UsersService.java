package com.training.userservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.userservice.dao.UserRepository;
import com.training.userservice.exceptions.UserNotFoundException;
import com.training.userservice.model.User;

@Service
public class UsersService {
	
	@Autowired
	UserRepository repo;
	
	public List<User> getUsers(){
		return (List<User>) repo.findAll();
	}

	
	public List<User> getUsersByPage(int pageNo,int pageSize){
		Pageable pageable=  PageRequest.of(pageNo, pageSize);
		 Page<User> page= repo.findAll(pageable);
		 
		 if (page.getContent().isEmpty())
			 throw new RuntimeException("No Records for this Page");
		return page.toList();
	}
	
	
	public List<User> getUserBySort(String sort,String asc){
		
		if(asc.equalsIgnoreCase("dsc"))
			return (List<User>) repo.findAll(Sort.by(sort).descending());
		
		return (List<User>) repo.findAll(Sort.by(sort).ascending());
	}
	
	
	public User getUserById(int uid) {
		return repo.findById(uid).orElseThrow(()->new UserNotFoundException("User not found with id: "+ uid));
	}
	
	public User getUserByName(String uname ) {
		return repo.getByUname(uname);
	}

	public List<User> getUserByaddr(String addr) {
		return repo.findByAddr(addr);
	}
	
	public User insertUser(User usr) {
		return repo.save(usr);
	}
	
	public User getunameandaddr(String uname,Integer id) {
		return repo.findDetailsBynameandId(uname, id);
	}
	
	
	public User updateUser(int uid,User usr) {
		User existing	= this.getUserById(uid);
		
			if(usr.getUname()!=null)
				existing.setUname(usr.getUname());
			if(usr.getAddr()!=null)
				existing.setAddr(usr.getAddr());
			
			return repo.save(existing);
		}
	
	public String deleteUser(int uid) {
		repo.deleteById(uid);
		return "User Deleted with ID :: "+ uid;
	}
}

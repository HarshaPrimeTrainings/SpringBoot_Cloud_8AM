package com.training.userservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.userservice.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	public User getByUname(String uname);
	
	public List<User> findByAddr(String addr);
	
	@Query(value= "select * from user where uname=:name and uid=:id",nativeQuery = true)
	public User findDetailsBynameandId(@Param(value = "name") String name, @Param(value = "id") Integer id);
}

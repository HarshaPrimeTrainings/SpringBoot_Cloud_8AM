package com.training.orderservice.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer>{

	public List<Orders> findByUid(Integer uid);
}

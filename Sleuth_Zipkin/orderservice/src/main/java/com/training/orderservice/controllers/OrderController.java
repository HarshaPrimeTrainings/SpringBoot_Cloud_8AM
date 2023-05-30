package com.training.orderservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.orderservice.dao.OrderRepository;
import com.training.orderservice.dao.Orders;

@RestController
public class OrderController {

	@Autowired
	OrderRepository orrepo;
	
	@GetMapping("/greet")
	public String greet() {
		
		return "Hello From OrderService!! Please WakeUp!!!!";
	}
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders(){
		return (List<Orders>) orrepo.findAll();
	}
	
	@PostMapping("/order")
	public Orders saveOrder(@RequestBody Orders ord) {
			return orrepo.save(ord);
	}
	
	@GetMapping("/order/{uid}")
	public List<Orders> getOrdersbyUid(@PathVariable Integer uid){
		return orrepo.findByUid(uid);
	}
	
	
}

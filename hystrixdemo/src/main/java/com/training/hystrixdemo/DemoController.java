package com.training.hystrixdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DemoController {

	@Autowired
	RestTemplate rest;

	@HystrixCommand(fallbackMethod = "myfallback",commandKey = "demokey")
	@GetMapping("/hello")
	public String greet() {
		return rest.getForObject("http://localhost:8080/home", String.class);
	}
	
	@HystrixCommand(fallbackMethod = "myfallback",commandKey = "mycommankdkey")
	@GetMapping("/hello1")
	public String greet1() {
		return rest.getForObject("http://localhost:8080/home", String.class);
	}
	
	
	public String myfallback() {
		System.out.println("Hello Fallback");
		return "<h1>Sorry at Present My Dev are lazy and sleeping please come after a decade</h1>";
	}
	
}

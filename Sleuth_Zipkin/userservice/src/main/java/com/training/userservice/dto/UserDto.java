package com.training.userservice.dto;

import java.util.List;

public class UserDto {
	
	private Integer uid;
	private String uname;
	private String addr;
	private List<OrderDto> orders;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public List<OrderDto> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDto> orders) {
		this.orders = orders;
	}
	
}

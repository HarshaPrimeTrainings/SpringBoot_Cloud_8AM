package com.training.userservice.model;


public class User {
	
	private int uid;
	private String uname;
	private String addr;
	
	
	public User(int uid, String uname, String addr) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.addr = addr;
	}
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
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


	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", addr=" + addr + "]";
	}
	
	

}

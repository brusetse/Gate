package com.bruse.el.po;

public class User {

	private String uname;
	private String phone;
	private Address addr;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public User(String uname, String phone, Address addr) {
		super();
		this.uname = uname;
		this.phone = phone;
		this.addr = addr;
	}
	public User() {
		super();
	}
	public User(String uname, String phone) {
		super();
		this.uname = uname;
		this.phone = phone;
	}
}

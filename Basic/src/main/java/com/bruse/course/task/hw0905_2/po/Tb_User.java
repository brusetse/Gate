package com.bruse.course.task.hw0905_2.po;

import java.util.Date;

public class Tb_User {

	private int user_id;
	private String qq;
	private String password;
	private String username;
	private Date regtime;
	private String addr;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Tb_User(int user_id, String qq, String username, Date regtime,
			String addr) {
		super();
		this.user_id = user_id;
		this.qq = qq;
		this.username = username;
		this.regtime = regtime;
		this.addr = addr;
	}
	
	
}

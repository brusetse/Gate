package com.bruse.course.net.server;

import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String pwd;
	
	public User() {
		super();
	}

	public User(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}

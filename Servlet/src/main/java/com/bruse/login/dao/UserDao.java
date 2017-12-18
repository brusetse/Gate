package com.bruse.login.dao;


import com.bruse.login.po.User;

public interface UserDao {

	public User findUser(String uname, String pwd);
}

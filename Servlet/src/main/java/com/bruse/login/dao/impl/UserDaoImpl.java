package com.bruse.login.dao.impl;

import com.bruse.login.dao.UserDao;
import com.bruse.login.po.User;
import com.bruse.login.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserDaoImpl implements UserDao {


	public User findUser(String uname, String pwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from User where uname=? and pwd=?";
		conn = DBUtil.getConn();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while(rs.next()){
				return new User(rs.getInt("id"),rs.getString("uname"),rs.getString("pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		
		
		
		return null;
	}

}

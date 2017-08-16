package com.bruse.course.quartz.util;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbcUtil {
	//获取连接
	public static Connection getConn(){
		String driver = "oracle.jdbc.driver.OracleDriver";//连接数据库的方法
		String url = "jdbc:oracle:thin:@localhost:1521:orcl"; //orcl为数据库的SID
		String username = "scott";//用户名
		String password = "tiger"; //密码
		Connection connection = null;
		try {
			Class.forName(driver);//加载数据库驱动
			connection = DriverManager.getConnection(url, username, password);//建立连接
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	//关闭ResultSet、Statement、Connection
	public static void close(ResultSet rs,Statement ps,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
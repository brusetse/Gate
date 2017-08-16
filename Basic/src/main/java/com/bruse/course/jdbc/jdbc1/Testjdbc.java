package com.bruse.course.jdbc.jdbc1;

import com.bruse.course.jdbc.util.DbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Testjdbc {

	public static void getDbc(){
		Connection connection = null;
		ResultSet rs = null;

		try {
			connection = DbcUtil.getConn();
//			获取statement静态处理对象
			Statement sta = connection.createStatement();
//			获取结果集 执行查询操作
			rs = sta.executeQuery("select * from emp1");
			while(rs.next()){
				System.out.print(rs.getInt(1)+"     ");
				System.out.print(rs.getString(2)+"     ");
				System.out.print(rs.getString(3)+"     ");
				System.out.print(rs.getInt(4)+"     ");
				System.out.print(rs.getDate(5)+"     ");
				System.out.print(rs.getInt(6)+"     ");
				System.out.print(rs.getInt(7)+"     ");
				System.out.println(rs.getInt(8)+"     ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}



	public static void main(String[] args) {
		getDbc();
	}
}

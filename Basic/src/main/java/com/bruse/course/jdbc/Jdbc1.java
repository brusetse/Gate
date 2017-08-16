package com.bruse.course.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1 {

	public static void testjdbc(){
		String driver="oracle.jdbc.driver.OracleDriver"; //连接数据库的方法
		String url="jdbc:oracle:thin:@localhost:1521:orcl"; //orcl为数据库的SID
		String username="scott"; //用户名
		String password="tiger"; //密码
		Connection connection = null;
		try {
			Class.forName(driver);//加载数据库驱动
			connection=DriverManager.getConnection(url,username,password);
			System.out.println(connection);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void createTable(){
		String driver="oracle.jdbc.driver.OracleDriver"; //连接数据库的方法
		String url="jdbc:oracle:thin:@localhost:1521:orcl"; //orcl为数据库的SID
		String username="scott"; //用户名
		String password="tiger"; //密码
		Connection connection = null;
		try {
			Class.forName(driver);//加载数据库驱动
			connection=DriverManager.getConnection(url,username,password);
			System.out.println(connection);
			//静态sql对象
			Statement sta = connection.createStatement();

			int rs0 = sta.executeUpdate("create sequence seq_id start with 8000 increment by 1");
			int rs1 = sta.executeUpdate("insert into emp1(empno,ename,sal,deptno) values(seq_id.nextval,'zhangsan',8000,20)");
			int rs2 = sta.executeUpdate("insert into emp1(empno,ename,sal,deptno) values(seq_id.nextval,'lisi',7000,30)");
			int rs3 = sta.executeUpdate("insert into emp1(empno,ename,sal,deptno) values(seq_id.nextval,'wangwu',9000,10)");


//			while(rs.next()){
//				System.out.println(rs.toString());
//			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//		testjdbc();
		createTable();
	}
}
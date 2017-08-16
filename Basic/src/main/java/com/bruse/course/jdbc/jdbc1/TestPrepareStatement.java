package com.bruse.course.jdbc.jdbc1;

import com.bruse.course.jdbc.util.DbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;


public class TestPrepareStatement {

	public static void queryData(String ename){
		Connection conn = null;
		conn = DbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql ="select * from emp where ename=?";
		try {
			//sql预编译
			ps = conn.prepareStatement(sql);
			//占位符传参数
			ps.setString(1, ename);
			//执行sql语句
			rs = ps.executeQuery();
			//遍历打印
			while(rs.next()){
				System.out.println(rs.getString("ename"));
				System.out.println(rs.getInt("sal"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbcUtil.close(rs, ps, conn);
		}
	}

	public static void addData(){
		Connection conn = null;
		conn = DbcUtil.getConn();
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;

		Savepoint savepoint = null;

		String sql = "insert into emp1 values(?,?,?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		try {
			//改为手动提交事务
			conn.setAutoCommit(false);
			//sql预编译
			ps = conn.prepareStatement(sql);
			//占位符传参数
			ps.setInt(1, 8888);
			ps.setString(2, "zhangsan");
			ps.setString(3, "SALESMAN");
			ps.setInt(4, 89);
			ps.setString(5, "2001-07-20");
			ps.setInt(6,7000);
			ps.setInt(7,2000);
			ps.setInt(8, 10);
			ps.executeUpdate();
			//设置还原点
			savepoint  = conn.setSavepoint("savepoint01");
			//sql预编译
			ps2 = conn.prepareStatement(sql);
			ps2.setInt(1, 8217);
			ps2.setString(2, "lisi");
			ps2.setString(3, "SALESMAN");
			ps2.setInt(4, 89);
			ps2.setString(5, "2001-07-20");
			ps2.setInt(6,7000);
			ps2.setInt(7,2000);
			ps2.setInt(8, 10);
			//执行sql语句
			ps2.executeUpdate();
			//手动提交事务
			conn.commit();

			ps2.close();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				//发生异常时，回滚
				conn.rollback(savepoint);
				conn.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}finally{
				try {
					ps2.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DbcUtil.close(rs, ps, conn);
			}
		}
	}

	public static void updateData(String ename,int sal){
		Connection conn = null;
		conn = DbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "update emp1 set sal=? where ename=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, sal);
			ps.setString(2, ename);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbcUtil.close(rs, ps, conn);
		}
	}

	public static void deleteData(String ename){
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "delete from emp1 where ename=?";
		try {
			conn = DbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ename);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbcUtil.close(rs, ps, conn);
		}
	}

	public static void main(String[] args) {
//		queryData("JAMES");
		addData();
//		updateData("zhangsan", 7000);
//		deleteData("lisi");
	}

}
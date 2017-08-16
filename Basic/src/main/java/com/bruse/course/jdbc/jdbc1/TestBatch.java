package com.bruse.course.jdbc.jdbc1;

import com.bruse.course.jdbc.util.DbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestBatch {

	public static void addPreBatch(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DbcUtil.getConn();
		//动态传参
		String sql = "insert into sxt_user(id,username,password) values(seq_id.nextval,?,?)";
		try {
			//sql预编译对象 批处理
			ps = conn.prepareStatement(sql);
			//循环组装语句
			for (int i = 0; i < 50000; i++) {
				ps.setString(1, "liu"+i+"gou");
				ps.setString(2, i+"");
				//往批处理添加语句
				ps.addBatch();
				//提高效率 通过取模 一次执行700条语句
				if(i%700==0){
					ps.executeBatch();
					//清空批处理
					ps.clearBatch();
				}
			}
			//执行批处理
			ps.executeBatch();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbcUtil.close(rs, ps, conn);
		}

	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		addPreBatch();
		long end = System.currentTimeMillis();
		//计算执行时间
		System.out.println(end-start);
	}
}

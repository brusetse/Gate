package com.bruse.course.jdbc.jdbc1;

import com.bruse.course.jdbc.util.DbcUtil;
import oracle.jdbc.driver.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class TestProcedure {

	public static int delRepateData(String tablename,String columnname,int v_row){
		Connection conn = null;
		CallableStatement cs = null;
		conn = DbcUtil.getConn();
		try {
			cs = conn.prepareCall("{call delRepateData(?,?,?)}");
			cs.setString(1, tablename);
			cs.setString(2, columnname);
			cs.registerOutParameter(3, OracleTypes.NUMBER);
			cs.executeUpdate();
			v_row = cs.getInt(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbcUtil.close(null, null, conn);
			if (cs!=null) {
				try {
					cs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return v_row;
	}

	public static void main(String[] args) {
		int a = 1;
		a = delRepateData("sxt_user","username",a);
		System.out.println(a);
	}
}

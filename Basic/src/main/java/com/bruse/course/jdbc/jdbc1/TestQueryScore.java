package com.bruse.course.jdbc.jdbc1;

import com.bruse.course.jdbc.util.DbcUtil;
import oracle.jdbc.driver.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestQueryScore {
	public static void queryScoreByName(){
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		conn = DbcUtil.getConn();
		try {
//			cs = conn.prepareCall("{call queryScore(?,?,?,?)}");
//			cs.registerOutParameter(1, OracleTypes.VARCHAR);
//			cs.registerOutParameter(2, OracleTypes.NUMBER);
//			cs.registerOutParameter(3, OracleTypes.NUMBER);
//			cs.registerOutParameter(4, OracleTypes.NUMBER);
//			cs.execute();
//			System.out.print(cs.getString(1)+"  ");
//			System.out.print(cs.getInt(2)+"  ");
//			System.out.print(cs.getInt(3)+"  ");
//			System.out.println(cs.getInt(4)+"  ");
			cs = conn.prepareCall("{call queryScore(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			rs = (ResultSet) cs.getObject(1);
			while(rs.next()){
//				System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4));
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbcUtil.close(rs, null, conn);
			if (cs!=null) {
				try {
					cs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


	}

	public static void main(String[] args) {

		queryScoreByName();
	}
}
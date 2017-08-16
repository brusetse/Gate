package com.bruse.course.quartz.quartz1;

import com.bruse.course.quartz.util.DbcUtil;
import oracle.jdbc.driver.OracleTypes;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class MyJob implements Job{
	
	public static int setApproval(int v_row){
		Connection conn = null;
		CallableStatement cs = null;
		conn = DbcUtil.getConn();
		try {
			cs = conn.prepareCall("{call setApproval(?)}");
			cs.registerOutParameter(1, OracleTypes.NUMBER);
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
	
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		int a = 1;
		a = setApproval(a);
		System.out.println(a);
	}
}
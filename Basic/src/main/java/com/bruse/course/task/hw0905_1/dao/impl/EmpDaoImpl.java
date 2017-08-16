package com.bruse.course.task.hw0905_1.dao.impl;

import com.bruse.course.task.hw0905_1.dao.EmpDao;
import com.bruse.course.task.hw0905_1.util.DbcUtil;
import com.bruse.course.task.hw0905_1.vo.EmpVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;




public class EmpDaoImpl implements EmpDao {

	public List<EmpVo> findEmp() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs  = null;
		ArrayList<EmpVo> empList = new ArrayList<EmpVo>();
		try {
			conn = DbcUtil.getConn();
			String sql = "select e.ename,e.sal,d.dname from emp e join dept d on e.deptno=d.deptno";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				empList.add(new EmpVo(rs.getString("ename"),rs.getInt("sal"),rs.getString("dname")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbcUtil.close(rs, ps, conn);
		}
		return empList;
	}


}

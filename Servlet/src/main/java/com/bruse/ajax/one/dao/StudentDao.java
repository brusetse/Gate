package com.bruse.ajax.one.dao;

import com.bruse.ajax.one.util.DBUtil;
import com.bruse.ajax.one.vo.Student;
import com.bruse.ajax.one.vo.TClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {

	public static List<Student> getStudent(int id){
		List<Student> list = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tb_student where class_id=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new Student(rs.getInt("student_id"),rs.getString("name"),rs.getInt("class_id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		
		return list;
	}
	
	public static List<TClass> getTClass(){
		List<TClass> list = new ArrayList<TClass>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from tb_class";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new TClass(rs.getInt("class_id"),rs.getString("class_name")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		
		return list;
	}
}

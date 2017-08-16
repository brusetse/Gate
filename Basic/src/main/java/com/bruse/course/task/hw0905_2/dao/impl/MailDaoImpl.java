package com.bruse.course.task.hw0905_2.dao.impl;

import com.bruse.course.task.hw0905_2.dao.MailDao;
import com.bruse.course.task.hw0905_2.po.Tb_User;
import com.bruse.course.task.hw0905_2.util.DbcUtil;
import com.bruse.course.task.hw0905_2.vo.ReceiveMail;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MailDaoImpl implements MailDao{

	public Tb_User queryUser(String qq,String password){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select t.user_id,t.qq,t.password,t.username,t.regtime,t.addr from tb_user t where t.qq =?";
		Tb_User u = null;
//		List userlist = new ArrayList();
		try {
			conn = DbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, qq);
			rs = ps.executeQuery();
			while (rs.next()) {
				u = new Tb_User(rs.getInt("user_id"),rs.getString("qq"),rs.getString("username"),rs.getDate("regtime"),rs.getString("addr"));
			}
//			if(!password.equals(rs.getString("password"))){
//				System.out.println("密码错误！");
//			}else{
//				u = new Tb_User(rs.getString("qq"),rs.getString("username"),rs.getDate("regtime"),rs.getString("addr"));
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("QQ号或密码错误，请重新输入");
		}finally{
			DbcUtil.close(rs, ps, conn);
		}

		return u;
	}

	public void addMail(int userid,String title,String content,int status) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into sendbox(sendbox_id,sendtime,title,content,send_userid,status)"
				+ " values(seq_sendbox_id.nextval,?,?,?,?,?)";

		try {
			conn = DbcUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setDate(1, new Date(new java.util.Date().getTime()));
			ps.setString(2, title);
			ps.setString(3, content);
			ps.setInt(4, userid);
			ps.setInt(5, status);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbcUtil.close(rs, ps, conn);
		}
	}

	public List<ReceiveMail> queryReceiveMail(int userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs  = null;
		ArrayList<ReceiveMail> empList = new ArrayList<ReceiveMail>();
		try {
			conn = DbcUtil.getConn();
			String sql = "select t2.username,t2.qq,s1.title,s1.sendtime,s1.status "
					+ "from receivebox r1 join tb_user t1 on r1.recieve_id = t1.user_id join sendbox s1"
					+ " on r1.mail_id = s1.sendbox_id join tb_user t2 on s1.send_userid = t2.user_id where t2.user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				empList.add(new ReceiveMail(rs.getString("username"),rs.getString("qq"),rs.getString("title"),rs.getDate("sendtime"),rs.getInt("status")));
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

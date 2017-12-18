package com.bruse.ajax.two.dao;

import com.bruse.ajax.two.util.DBUtil;
import com.bruse.ajax.two.vo.Area;
import com.bruse.ajax.two.vo.City;
import com.bruse.ajax.two.vo.Province;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AreaDao {

	public static List<Province> getProvince(){
		List<Province> list = new ArrayList<Province>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from province";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new Province(rs.getInt("provinceID"),rs.getString("province")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		
		return list;
	}
	
	public static List<City> getCity(int father){
		List<City> list = new ArrayList<City>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from city where father=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, father);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new City(rs.getInt("cityID"),rs.getString("city"),rs.getInt("father")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		
		return list;
	}
	
	public static List<Area> getArea(int father){
		List<Area> list = new ArrayList<Area>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from area where father=?";
		try {
			conn = DBUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, father);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new Area(rs.getInt("areaID"),rs.getString("area"),rs.getInt("father")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.close(rs, ps, conn);
		}
		
		return list;
	}
}

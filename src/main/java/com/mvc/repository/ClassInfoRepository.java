package com.mvc.repository;

import java.sql.*;
import java.util.*;

public class ClassInfoRepository {
	
	public List<Map<String,String>> SelectClassInfoList() {
		List<Map<String,String>> classInfoList = new ArrayList<>();
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/kd";
		String user = "root";
		String pwd = "kd1824java";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Map<String,String> classInfo = new HashMap<>();
				classInfo.put("CI_NUM", rs.getString("CI_NUM"));
				classInfo.put("CI_NAME", rs.getString("CI_NAME"));
				classInfo.put("CI_AGE", rs.getString("CI_AGE"));
				classInfoList.add(classInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classInfoList;
	}
	public Map<String,String> SelectClassInfo(String ciNum) {
		Map<String,String> classInfo = new HashMap<>();
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3306/kd";
		String user = "root";
		String pwd = "kd1824java";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM CLASS_INFO WHERE 1=1 AND CI_NUM=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ciNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				classInfo.put("CI_NUM", rs.getString("CI_NUM"));
				classInfo.put("CI_NAME", rs.getString("CI_NAME"));
				classInfo.put("CI_AGE", rs.getString("CI_AGE"));
				return classInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

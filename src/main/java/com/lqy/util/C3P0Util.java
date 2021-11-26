package com.lqy.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	
	private static ComboPooledDataSource cpds = new ComboPooledDataSource("mysql");
	
//	static{
//		
//		try {
//			cpds.setDriverClass("com.mysql.jdbc.Driver");
//			cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test2?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8&useSSL=false");
//			cpds.setUser("root");                                  
//			cpds.setPassword("root");
//		} catch (PropertyVetoException e) {
//			e.printStackTrace();
//		}             
//	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void release(Statement stmt, Connection conn, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null; // 垃圾回收，上！
			}
			if (stmt != null) {
				stmt.close();
				stmt = null; // 垃圾回收，上！
			}
			if (conn != null) {
				conn.close();
				conn = null; // 垃圾回收，上！
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		System.out.println(cpds);
		System.out.println(cpds.getDriverClass());
		System.out.println(cpds.getJdbcUrl());
		System.out.println(cpds.getUser());
		System.out.println(cpds.getPassword());
	}

}

package com.lqy.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;

public class JdbcUtil {

	private static String driverClass = null;
	private static String url = null;
	private static String name = null;
	private static String pwd = null;

	static {

		InputStream is = JdbcUtil.class.getClassLoader().getResourceAsStream(
				"db.properties");
		Properties props = new Properties();

		try {
			props.load(is);

			driverClass = props.getProperty("mysql.driverClass");
			url = props.getProperty("mysql.url");
			name = props.getProperty("mysql.name");
			pwd = props.getProperty("mysql.pwd");

			Class.forName(driverClass);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, name, pwd);
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
		System.out.println(driverClass);
		System.out.println(url);
		System.out.println(name);
		System.out.println(pwd);
	}

}

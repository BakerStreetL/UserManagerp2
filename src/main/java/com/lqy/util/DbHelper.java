package com.lqy.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.lqy.model.Users;

public class DbHelper {
	
	private static Connection conn=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	public static Connection getConn() {
		return conn;
	}

	public static PreparedStatement getPs() {
		return ps;
	}

	public static int executeUpdate(String sql,Object[] params){
		
		int res=0;
		
		try {
//			conn=JdbcUtil.getConnection();
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			
			//对？赋值
			if(params!=null){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			
			res=ps.executeUpdate();
			
//			JdbcUtil.release(ps, conn, rs);
			C3P0Util.release(ps, conn, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static ResultSet executeQuery(String sql,Object[] params){
		
		ResultSet rs=null;
		
		try {
//			conn=JdbcUtil.getConnection();
			conn=C3P0Util.getConnection();
			ps=conn.prepareStatement(sql);
			
			//对？赋值
			if(params!=null){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			
			rs=ps.executeQuery();
			
//			JdbcUtil.release(ps, conn, rs);	//延迟关闭
//			C3P0Util.release(ps, conn, rs);	//延迟关闭
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
}

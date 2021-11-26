package com.lqy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo1 {

	public static void main(String[] args) throws Exception {
		
		//1、注册并加载驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2、获取数据库连接
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "root");
		//3、创建表示sql的语句对象
		Statement stmt=conn.createStatement();
		//4、执行sql，如果有结果，写入结果集
		String sql="insert into users(name,nickName,pwd,gender,birthday,hobby,tel,email,grade,description) "
				+ "values('张三', '老三', '12345', '1', '2006-06-06 00:00:00', '吃饭,睡觉', '13000000123', '12345@qq.com', '5', '无')";
		int res=stmt.executeUpdate(sql);
		//5、遍历结果集
		System.out.println("影响的行数是："+res+"行。");
		//6、关闭资源
		if(stmt!=null){
			stmt.close();
			stmt=null;	//垃圾回收，上！
		}
		if(conn!=null){
			conn.close();
			conn=null;	//垃圾回收，上！
		}
		

	}

}

package com.lqy.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.lqy.dao.UserDao;
import com.lqy.exception.IdIsNullException;
import com.lqy.model.Users;

public class UserDaoImpl implements UserDao {

	@Override
	public int addUser(Users users) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delUserById(Integer id) throws IdIsNullException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateById(Users users) throws IdIsNullException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Users getUserByName(String name, String pwd) {

		Users user=null;
		
		try {
			//1、注册并加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2、获取数据库连接
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/java?serverTimezone=GMT&useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "root");
			//3、创建表示sql的语句对象
			Statement stmt=conn.createStatement();
			//4、执行sql，如果有结果，写入结果集
			String sql="select * from users where name='"+name+"' and pwd='"+pwd+"'";
			//System.out.println("sql="+sql);
			ResultSet rs=stmt.executeQuery(sql);
			//5、遍历结果集
			if(rs.next()){
				// 封装
				user=new Users();
				
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setNickName(rs.getString("nickName"));
				user.setPwd(rs.getString("pwd"));
				user.setGender(rs.getString("gender"));
				user.setBirthday(rs.getDate("birthday"));
				user.setHobby(rs.getString("hobby"));
				user.setTel(rs.getString("tel"));
				user.setEmail(rs.getString("email"));
				user.setGrade(rs.getInt("grade"));
				user.setDescription(rs.getString("description"));
			}
			
			//6、关闭资源
			if(stmt!=null){
				stmt.close();
				stmt=null;	//垃圾回收，上！
			}
			if(conn!=null){
				conn.close();
				conn=null;	//垃圾回收，上！
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
				
		return user;
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}

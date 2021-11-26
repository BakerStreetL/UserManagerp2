package com.lqy.dao.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.lqy.dao.UserDao;
import com.lqy.exception.IdIsNullException;
import com.lqy.model.Users;
import com.lqy.util.C3P0Util;
import com.lqy.util.DbHelper;


public class UserDaoImpl2 implements UserDao {

	@Override
	public int addUser(Users users) {

		int rs=0;

		try {    //没有要hobby,tel,email,grade,description
			String sql="insert into users(name,nickName,pwd,gender,birthday)values(?,?,?,?,?)";
			String name = users.getName();
			String nickName = users.getNickName();
			String pwd = users.getPwd();
			String gender = users.getGender();
			Date birthday = users.getBirthday();
			//String hobby = users.getHobby();
			//String tel = users.getTel();
			//String email = users.getEmail();
			//int grade = users.getGrade();
			//String description = users.getDescription();


			SimpleDateFormat date2=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date=date2.format(birthday);
			//String gd=String.valueOf(grade);
			String[] params={name,nickName,pwd,gender,date};   //没有要hobby,tel,email, gd,description
			rs=DbHelper.executeUpdate(sql, params);
			System.out.println("有"+rs+"行记录被增加！");


			//6、关闭资源
//			//JdbcUtil.release(DbHelper.getPs(), DbHelper.getConn(), rs);
			//C3P0Util.release(DbHelper.getPs(), DbHelper.getConn(), rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs;
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
			String sql="select * from users where name=? and pwd=?";
			String[] params={name,pwd};
			ResultSet rs=DbHelper.executeQuery(sql, params);
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
//			JdbcUtil.release(DbHelper.getPs(), DbHelper.getConn(), rs);
			C3P0Util.release(DbHelper.getPs(), DbHelper.getConn(), rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public List<Users> getAllUsers() {

		List<Users> users=null;

		Users user=null;

		try {
			String sql="select * from users";
			ResultSet rs=DbHelper.executeQuery(sql, null);
			//5、遍历结果集
			users= new ArrayList<Users>();
			while(rs.next()){
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

				users.add(user);
			}

			//6、关闭资源
//			JdbcUtil.release(DbHelper.getPs(), DbHelper.getConn(), rs);
			C3P0Util.release(DbHelper.getPs(), DbHelper.getConn(), rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

}

package com.lqy.service.impl;

import java.util.List;

import com.lqy.model.Users;
import com.lqy.service.UserService;
import com.lqy.dao.UserDao;
import com.lqy.dao.impl.UserDaoImpl;
import com.lqy.dao.impl.UserDaoImpl2;
import com.lqy.exception.IdIsNullException;
import com.lqy.model.Users;
import com.lqy.service.UserService;
import com.lqy.util.Base64Encoder;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao = new UserDaoImpl2();//依赖注入

	@Override
	public int addUser(Users users) {
		// TODO Auto-generated method stub
		return userDao.addUser(users);
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

		//return userDao.getUserByName(name, Base64Encoder.encode(pwd));
		return userDao.getUserByName(name, pwd);
	}

	@Override
	public List<Users> getAllUsers() {
		return userDao.getAllUsers();
	}

}

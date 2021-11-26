package com.lqy.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lqy.dao.UserDao;
import com.lqy.dao.impl.UserDaoImpl;
import com.lqy.dao.impl.UserDaoImpl2;
import com.lqy.model.Users;
import com.lqy.util.Base64Encoder;

public class UserDaoImplTest {
	
	private UserDao userDao = new UserDaoImpl2();

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelUserById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserByName() {
		
		Users users=userDao.getUserByName("宋江", Base64Encoder.encode("123"));
		
		//断言
		assertNotEquals(null, users);
		
		System.out.println(users);
		
	}

	@Test
	public void testGetAllUsers() {
		List<Users>users=userDao.getAllUsers();
		
		//断言
		assertNotEquals(null, users);
		
		System.out.println(users);
	}
}

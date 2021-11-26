package com.lqy.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lqy.dao.UserDao;
import com.lqy.dao.impl.UserDaoImpl;
import com.lqy.model.Users;
import com.lqy.service.UserService;
import com.lqy.service.impl.UserServiceImpl;

public class UserServiceImplTest {
	
	private UserService userService = new UserServiceImpl();

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
		Users users=userService.getUserByName("林冲", "123");
		assertNotEquals(null, users);
		
		System.out.println(users);
	}

	@Test
	public void testGetAllUsers() {
		List<Users>users=userService.getAllUsers();
		assertNotEquals(null, users);
		
		System.out.println(users);
	}

}

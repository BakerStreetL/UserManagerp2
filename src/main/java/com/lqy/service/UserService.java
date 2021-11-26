package com.lqy.service;

import java.util.List;

import com.lqy.exception.IdIsNullException;
import com.lqy.model.Users;
import com.lqy.exception.IdIsNullException;
import com.lqy.model.Users;

public interface UserService {
	
	/**
	 * 添加用户
	 * @param users
	 * @return
	 */
	public int addUser(Users users);
	
	/**
	 * 根据id删除单个用户
	 * @param id
	 * @return
	 * @throws IdIsNullException
	 */
	public int delUserById(Integer id) throws IdIsNullException, IdIsNullException;
	
	/**
	 * 根据id修改单个用户
	 * @param users
	 * @return
	 * @throws IdIsNullException
	 */
	public int updateById(Users users) throws IdIsNullException;
	
	/**
	 * 根据用户名和密码查询单个用户
	 * @param name
	 * @param pwd
	 * @return
	 */
	public Users getUserByName(String name, String pwd);

	/**
	 * 查询所有用户
	 * @return
	 */
	public List<Users> getAllUsers();

}

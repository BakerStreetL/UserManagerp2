package com.lqy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lqy.model.Users;
import com.lqy.service.UserService;
import com.lqy.service.impl.UserServiceImpl;

public class LoginController extends HttpServlet {

	private UserService userService = new UserServiceImpl();

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();

		String name = req.getParameter("username");
		String pwd = req.getParameter("password");
		Users users=userService.getUserByName(name, pwd);
		if (users!=null) {
			req.getRequestDispatcher("/Main").forward(req, res);//请求转发
		}else{
			String errMsg="用户不存在或密码错误，请重新输入！";
			req.setAttribute("errMsg", errMsg);
			req.getRequestDispatcher("/Login").forward(req, res);//请求转发
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		this.doGet(req, res);

	}

}
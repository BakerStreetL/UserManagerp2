package com.lqy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lqy.model.Users;
import com.lqy.service.UserService;
import com.lqy.service.impl.UserServiceImpl;

public class UserController extends HttpServlet {
	
	private UserService userService = new UserServiceImpl();

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		String type=req.getParameter("type");
		
		if ("getAllUsers".equals(type)) {
			getAllUsers(req,res);
		}

	}

	private void getAllUsers(HttpServletRequest req, HttpServletResponse res) {
		List<Users> userList=userService.getAllUsers();
		req.setAttribute("userList", userList);
		try {
			req.getRequestDispatcher("/Manage").forward(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		this.doGet(req, res);

	}

}

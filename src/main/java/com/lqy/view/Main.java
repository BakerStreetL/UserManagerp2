package com.lqy.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<html><head><title>login</title>");
		out.println("<meta http-equiv='keywords' content='keyword1,keyword2,keyword3'>");
		out.println("<meta http-equiv='description' content='this is my page'>");
		out.println("<meta http-equiv='content-type' content='text/html; charset=UTF-8'>");
		out.println("<!--<link rel='stylesheet' type='text/css' href='./styles.css'>-->");
		out.println("</head><body>");
		out.println("<img src='img/header.jpg' width='150px' height='50px' /><hr/>");
		out.println("<h1>用户界面</h1>");
		out.println("<a href='/UserManagerp2/UserController?type=getAllUsers'>用户管理</a><br />");
		out.println("<a href='/UserManagerp2/Register'>添加用户</a><br />");//新建registercontroller
		out.println("<a href='#'>安全退出</a><br />");
		out.println("<hr/><img src='img/footer.jpg' width='150px' height='50px' />");
		out.println("</body></html>");

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		this.doGet(req, res);

	}

}

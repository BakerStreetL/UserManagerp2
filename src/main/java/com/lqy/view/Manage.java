package com.lqy.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lqy.model.Users;

public class Manage extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		List<Users> userList=(List<Users>) req.getAttribute("userList");
		
		out.println("<html><head><title>login</title>");
		out.println("<meta http-equiv='keywords' content='keyword1,keyword2,keyword3'>");
		out.println("<meta http-equiv='description' content='this is my page'>");
		out.println("<meta http-equiv='content-type' content='text/html; charset=UTF-8'>");
		out.println("<!--<link rel='stylesheet' type='text/css' href='./styles.css'>-->");
		out.println("</head><body>");
		out.println("<img src='img/header.jpg' width='150px' height='50px' /><hr/>");
		out.println("<h1>用户管理</h1>");
		out.println("<table border='1' style='border-collapse: collapse'>");
		out.println("<tr>"
				+ "<th>姓名</th>"
				+ "<th>昵称</th>"
				+ "<th>性别</th>"
				+ "<th>生日</th>"
				+ "<th>爱好</th>"
				+ "<th>电话</th>"
				+ "<th>邮箱</th>"
				+ "<th>等级</th>"
				+ "<th>描述</th>"
				+ "<th>操作</th>"
				+ "</tr>");
		for (int i = 0; i < userList.size(); i++) {
			Users users =userList.get(i);
			out.println("<tr>"
					+ "<td>"+users.getName()+"</td>"
					+ "<td>"+users.getNickName()+"</td>"
					+ "<td>"+users.getGender()+"</td>"
					+ "<td>"+users.getBirthday()+"</td>"
					+ "<td>"+users.getHobby()+"</td>"
					+ "<td>"+users.getTel()+"</td>"
					+ "<td>"+users.getEmail()+"</td>"
					+ "<td>"+users.getGrade()+"</td>"
					+ "<td>"+users.getDescription()+"</td>"
					+ "<td><a href='#'>删除</a>&nbsp;&nbsp;<a href='#'>修改</a></td>"
					+ "</tr>");
		}
		out.println("</table><hr/><img src='img/footer.jpg' width='150px' height='50px' />");
		out.println("</body></html>");

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		this.doGet(req, res);

	}

}

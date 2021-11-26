package com.lqy.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();

		String errMsg=(String)req.getAttribute("errMsg");

		out.println("<html><head><title>login</title>");
		out.println("<meta http-equiv='keywords' content='keyword1,keyword2,keyword3'>");
		out.println("<meta http-equiv='description' content='this is my page'>");
		out.println("<meta http-equiv='content-type' content='text/html; charset=UTF-8'>");
		out.println("<!--<link rel='stylesheet' type='text/css' href='./styles.css'>-->");
		out.println("</head><body>");
		out.println("<img src='img/header.jpg' width='150px' height='50px' /><hr/>");
		out.println("<h1>用户登录</h1>");
		if(errMsg!=null){
			out.println(errMsg);
		}
		out.println("<form action='/UserManagerp2/LoginController' method='post'>");
		out.println("<label for='name' >用户名：</label><br/>");
		out.println("<input type='text' name='username' id='name'/><br/>");
		out.println("<label for='pwd' >密&nbsp;&nbsp;码：</label><br/>");
		out.println("<input type='text' name='password' id='pwd'/><br/>");
		out.println("<input type='submit' value='提交' />");
		out.println("<input type='reset' value='重置' />");
		out.println("<a href='/UserManagerp2/Register'>注册</a><br />");
		//out.println("<input type='register' <a href='/UserManagerp2/Register'value='注册' /></a>");
		out.println("</form>");
		out.println("<hr/><img src='img/footer.jpg' width='150px' height='50px' />");
		out.println("</body></html>");

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		this.doGet(req, res);

	}

}

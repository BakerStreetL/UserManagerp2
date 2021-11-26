package com.lqy.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet {
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
        out.println("<h1>用户注册</h1>");
        out.println("<h2>请输入相关信息</h2>");
        if(errMsg!=null){
            out.println(errMsg);
        }

        //最先开始时，注册页面实现的是填完整个表格，即10个信息，后来改为填写前5个
        out.println("<form action='/UserManagerp2/RegisterController' method='post'>");

        out.println("<label for='name' >用户名：</label><br/>");
        out.println("<input type='text' name='username' id='name'/><br/>");

        out.println("<label for='nickName' >昵&nbsp;&nbsp;称：</label><br/>");
        out.println("<input type='text' name='nickName' id='nickName'/><br/>");

        out.println("<label for='pwd' >密&nbsp;&nbsp;码：</label><br/>");
        out.println("<input type='text' name='password' id='pwd'/><br/>");

        out.println("<label for='pwd1' >请再次输入密码：</label><br/>");
        out.println("<input type='text' name='password1' id='pwd1'/><br/>");

        out.println("<label for='gender' >性&nbsp;&nbsp;别：</label><br/>");
        out.println("<input type='text' name='gender' id='gender'/><br/>");

        out.println("<label for='birthday' >生&nbsp;&nbsp;日：</label><br/>");
        out.println("<input type='text' name='birthday' id='birthday'/><br/>");

        out.println("<label for='hobby' >爱&nbsp;&nbsp;好：</label><br/>");
        out.println("<input type='text' name='hobby' id='hobby'/><br/>");

        out.println("<label for='tel' >电&nbsp;&nbsp;话：</label><br/>");
        out.println("<input type='text' name='telPhone' id='tel'/><br/>");

        out.println("<label for='email' >邮&nbsp;&nbsp;箱：</label><br/>");
        out.println("<input type='text' name='email' id='email'/><br/>");

        out.println("<label for='grade' >等&nbsp;&nbsp;级：</label><br/>");
        out.println("<input type='text' name='grade' id='grade'/><br/>");

        out.println("<label for='description' >描&nbsp;&nbsp;述：</label><br/>");
        out.println("<input type='text' name='description' id='description'/><br/>");
        out.println("<input type='submit' value='注册' />");
        out.println("<input type='reset' value='重置' />");
        out.println("</form>");
        out.println("<hr/><img src='img/footer.jpg' width='150px' height='50px' />");
        out.println("</body></html>");

    }
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        this.doGet(req, res);

    }


}

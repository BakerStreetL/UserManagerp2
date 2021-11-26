package com.lqy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lqy.model.Users;
import com.lqy.service.UserService;
import com.lqy.service.impl.UserServiceImpl;

public class RegisterController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out = res.getWriter();
        //Users users = new Users();
        try {
            String name = req.getParameter("username");
            String nickName = req.getParameter("nickName");
            String pwd = req.getParameter("password");
            String gender = req.getParameter("gender");
            String birthday = req.getParameter("birthday");
            String pwd1 = req.getParameter("password1");

            if (!pwd.equals(pwd1)) {   //密码前后不一致的情况
                //
                //err
                String errMsg="密码不一致，请重新输入！";
                req.setAttribute("errMsg", errMsg);
                req.getRequestDispatcher("/Register").forward(req, res);//请求转发
                return ;
            }

            if(pwd.length()<8){
                //err
                String errMsg="密码长度不足八位，请重新输入！";
                req.setAttribute("errMsg", errMsg);
                req.getRequestDispatcher("/Register").forward(req, res);//请求转发
                return ;
            }

            if(!pwd.matches(".*\\d+.*")){
                //err
                String errMsg="密码不含数字，请重新输入！";
                req.setAttribute("errMsg", errMsg);
                req.getRequestDispatcher("/Register").forward(req, res);//请求转发
                return ;
            }
            if(!pwd.matches(".*[a-zA-Z]+.*")) {
                //err
                String errMsg = "密码不含字母，请重新输入！";
                req.setAttribute("errMsg", errMsg);
                req.getRequestDispatcher("/Register").forward(req, res);//请求转发
                return;
            }



//            String hobby = req.getParameter("hobby");
//            String tel = req.getParameter("telPhone");
//            String email = req.getParameter("email");
//            String grade = req.getParameter("grade");
//            String description = req.getParameter("description");
            Users users = new Users();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = ft.parse(birthday);
            users.setBirthday(date);
            users.setName(name);
            users.setNickName(nickName);
            users.setPwd(pwd);
            users.setGender(gender);
//            users.setHobby(hobby);
//            users.setTel(tel);
//            users.setEmail(email);
//            users.setGrade(Integer.parseInt(grade));
//            users.setDescription(description);

            int flag=userService.addUser(users);


            if (flag!=0) {
                //succ 跳转到登录
                String Msg="注册成功，请登录！";
                req.setAttribute("errMsg", Msg);
                req.getRequestDispatcher("/Login").forward(req, res);//请求转发
            }else{
                //err
                String errMsg="注册不成功，请重新注册！";
                req.setAttribute("errMsg", errMsg);
                req.getRequestDispatcher("/Register").forward(req, res);//请求转发
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void addUser(HttpServletRequest req, HttpServletResponse res){
        //先接受各个参数

        //封装user

        //

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        this.doGet(req, res);

    }

}

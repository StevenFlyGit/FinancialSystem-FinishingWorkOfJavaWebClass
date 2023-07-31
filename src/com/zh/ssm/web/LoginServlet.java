package com.zh.ssm.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zh.ssm.bean.Users;
import com.zh.ssm.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService userService = new UserService();
		String username = request.getParameter("username");//用户向服务器请求的数据
		String password = request.getParameter("password");
		Users users = userService.findUserByName(username);
		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter writer = response.getWriter();
		
//		Users users = userService.findUserByName(username);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String docType ="<!DOCTYPE html> \\n";
		if(users != null && users.getPassword().equals(password)){
			//登录后显示欢迎数据库中的realname
			request.getSession().setAttribute("realname", users.getRealname());
			//if分支去main页面,需要转发和重定向去main。站内跳转用forward
			request.getRequestDispatcher("WEB-INF/main.jsp").forward(request, response);
//			writer.println(docType + 
//					"<html>\n" +
//		            "<head><title>用户登录</title></head>\n" +
//		            "<body bgcolor=\"#f0f0f0\">\n" +
//		            "<h1 align=\"center\">用户登录 </h1>\n" +
//		            "<ul>\n" +
//		            "  <li><b>用户名</b>："
//		            + users.getName() + "\n" +
//		            "  <li><b>密码</b>："
//		            + users.getPassword() + "\n" +
//		            "</ul>\n" +
//		            "</body></html>"
//                 );
		} else {
//			writer.println("fail!");
			request.setAttribute("failMsg", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

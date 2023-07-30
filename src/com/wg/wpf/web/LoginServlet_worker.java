package com.wg.wpf.web;

import java.awt.desktop.UserSessionEvent;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wg.wpf.service.WorkerService;
import com.wg.wpf.bean.Workers;

/**
 * Servlet implementation class LoginServlet_worker
 */
@WebServlet("/LoginServlet_worker")
public class LoginServlet_worker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet_worker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		WorkerService workerService = new WorkerService();
		//用户向服务器请求的数据
		String workername = request.getParameter("workername");
		String password = request.getParameter("password");
		
		Workers workers = workerService.findWorkerByName(workername);
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	    String docType = "<!DOCTYPE html> \\n";
	    if(workers != null && workers.getPassword().equals(password)) {
	    	//登录后显示欢迎数据库中的realname
	    	request.getSession().setAttribute("realname", workers.getRealname());
	    	//if分支去main页面,需要转发和重定向去main。站内跳转用forward
	    	request.getRequestDispatcher("WEB-INF/main.jsp").forward(request, response);
	    } else {
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

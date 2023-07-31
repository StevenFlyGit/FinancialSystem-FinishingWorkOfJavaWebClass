package com.zh.ssm.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zh.ssm.bean.BasePage;
import com.zh.ssm.bean.Teacher;
import com.zh.ssm.service.TeacherService;

/**
 * Servlet implementation class TeacherListServlet
 */
@WebServlet("/teacher_list")
public class TeacherListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		TeacherService teacherService = new TeacherService();
		List<Teacher> list;
		
		//得到三个参数，对应数据库中的字段名
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone"); 
		//取得页码参数
		String numPerPageStr = request.getParameter("numPerPage");
		String currentPageStr = request.getParameter("currentPage");
		
		
		//去掉首位空格
		name = name == null ? "" : name.trim();
		sex = sex == null ? "" : sex;
		phone = phone == null ? "" : phone.trim();
		//数据类型转换
//		int numPerPage = Integer.valueOf(numPerPageStr);
//		int currentPage = Integer.valueOf(currentPageStr);
		
		int numPerPage = 20;
		if (numPerPageStr != null && numPerPageStr != "") {
			numPerPage = Integer.valueOf(numPerPageStr);
		}
		int currentPage = 1;
		if (currentPageStr != null && currentPageStr != "") {
			currentPage = Integer.valueOf(currentPageStr);
		}
        
		//当前显示多少页，一页显示多少记录
		BasePage basePage = new BasePage();
		basePage.setCurrentPage(currentPage);
		basePage.setNumPerPage(numPerPage);
		
//		String sql = "SELECT id, name, phone, sex FROM scs.teacher where 1=1";
		if (name == "" && sex =="" && phone == "") {
			list = teacherService.findAllTeacher(basePage);
		} else{
			list = teacherService.findAllTeacher(name,sex,phone);
		}
				
//		List<Teacher> list = teacherService.findAllTeacher();
		request.setAttribute("list", list);
		request.setAttribute("Page", basePage);
		request.getRequestDispatcher("WEB-INF/teacher_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

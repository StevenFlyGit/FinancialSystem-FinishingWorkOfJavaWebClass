package com.wg.wpf.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wg.wpf.bean.Manager;
import com.wg.wpf.service.ManagerService;
import com.wg.wpf.bean.BasePage;



/**
 * Servlet implementation class ManagerListServlet
 */
@WebServlet("/manager_list")
public class ManagerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BasePage basePage = new BasePage();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	    ManagerService managerService = new ManagerService();
		List<Manager> list;
		
		//得到参数，对应数据库中的字段名
		String name = request.getParameter("name");
		String phone = request.getParameter("phone"); 
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String idcard = request.getParameter("idcard");
		String salary = request.getParameter("salary");
		String insurance = request.getParameter("insurance");
		String bonus = request.getParameter("bonus");
		String tax = request.getParameter("tax");
		String position = request.getParameter("position"); 
		String email = request.getParameter("email");
		//取得页码参数
		String numPerPageStr = request.getParameter("numPerPage");
		String currentPageStr = request.getParameter("currentPage");
		String pageNumStr = request.getParameter("pageNum");
		
		//去掉首位空格
		name = name == null ? "" : name.trim();
		phone = phone == null ? "" : phone.trim();
		sex = sex == null ? "" : sex;
		age = age == null ? "" : age.trim();
		idcard = idcard == null ? "" : idcard.trim();
		salary = salary == null ? "" : salary.trim();
		insurance = insurance == null ? "" : insurance.trim();
		bonus = bonus == null ? "" : bonus.trim();
		tax = tax == null ? "" : tax.trim();
		position = position == null ? "" : position.trim();
		email = email == null ? "" : email.trim();
		
		
		if (numPerPageStr != request.getParameter("numPerPage")) {
			basePage.setNumPerPage(Integer.valueOf(numPerPageStr));
		}
		if (pageNumStr == null) {
			basePage.setCurrentPage(1);
		}else {
			basePage.setCurrentPage(Integer.parseInt(pageNumStr));
		}
		
		
		
		if (name == "" && phone == "" && sex == ""  && age == "" && idcard == "" && salary == "" && insurance == "" && bonus == "" && tax == "" && position == ""&& email == "") {
			list = managerService.findAllManager();
		} else{
			list = managerService.findAllManager(name, phone, sex, age, idcard, salary, insurance, bonus, tax, position, email);
		}
		
		request.setAttribute("list", list);
		request.setAttribute("Page", basePage);
		request.getRequestDispatcher("WEB-INF/manager_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

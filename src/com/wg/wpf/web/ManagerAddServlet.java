package com.wg.wpf.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.corba.se.spi.orbutil.threadpool.ThreadPoolChooser;
import com.wg.wpf.bean.Manager;
import com.wg.wpf.service.ManagerService;

/**
 * Servlet implementation class ManagerAddServlet
 */
@WebServlet("/manager_add")
public class ManagerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ManagerService managerService = new ManagerService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    
		String idString = request.getParameter("id");
		int id = Integer.valueOf(idString);
		Manager manager = managerService.findManagerById(id);
		request.setAttribute("manager", manager);
		request.getRequestDispatcher("resource/common/manager_add.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String idString = request.getParameter("id");
		
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
		
		Manager manager = new Manager();
		manager.setName(name);
		manager.setPhone(phone);
		manager.setSex(sex);
		manager.setAge(Integer.valueOf(age));
		manager.setIdcard(idcard);
		manager.setSalary(salary);
		manager.setInsurance(insurance);
		manager.setBonus(bonus);
		manager.setTax(tax);
		manager.setPosition(position);
		manager.setEmail(email);
		
		response.setContentType("text/html;charset=UTF-8");
		
		Boolean boolean1 = false;
		if (idString != "" && idString != null) {
			manager.setId(Integer.valueOf(idString).longValue());
			boolean1 = managerService.editManager(manager);
		}
		else {
			boolean1 = managerService.addManager(manager);
		}
		
		String message;
		if (boolean1) {
			message = "{\"statusCode\":\"200\", \"message\":\"操作成功\", \"navTabId\":\"managerlist\", \"callbackType\":\"forward\"}";
		}else {
			message = "{\"statusCode\":\"300\", \"message\":\"操作失败\"}";
		}
		response.getWriter().print(message);
	}

}

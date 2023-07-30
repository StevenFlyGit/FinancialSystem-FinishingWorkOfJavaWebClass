package com.wg.wpf.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wg.wpf.service.ManagerService;

/**
 * Servlet implementation class ManagerDeleteServlet
 */
@WebServlet("/manager_delete")
public class ManagerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idString = request.getParameter("id");
		Long id = Long.valueOf(idString);
		
		ManagerService managerService = new ManagerService();
		Boolean boolean1 = managerService.deleteManagerById(id);
		response.setContentType("text/html;charset=UTF-8");
		
		String message;
		if (boolean1) {
			message = "{\"statusCode\":\"200\", \"message\":\"操作成功\", \"navTabId\":\"managerlist\", \"callbackType\":\"closeCurrent\"}";
		}else {
			message = "{\"statusCode\":\"300\", \"message\":\"操作失败\"}";
		}
		response.getWriter().print(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

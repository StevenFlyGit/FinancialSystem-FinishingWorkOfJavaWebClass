package com.zh.ssm.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zh.ssm.bean.Teacher;
import com.zh.ssm.service.TeacherService;

/**
 * Servlet implementation class TeacherAddServlet
 */
@WebServlet("/teacher_add")
public class TeacherAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeacherService teacherService =  new TeacherService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
////		response.getWriter().append("Served at: ").append(request.getContextPath());
//		TeacherService teacherService =  new TeacherService();
//		
//		String name = request.getParameter("name");
//		String phone = request.getParameter("phone");
//		String sex = request.getParameter("sex");
//		
//		//数据类型转换
////		String ageStr = request.getParameter("age");
////		int age = Integer.valueOf(ageStr);
////		double age2 = Double.valueOf(ageStr);
//		
//		Teacher teacher = new Teacher();
//		teacher.setName(name);
//		teacher.setPhone(phone);
//		teacher.setSex(sex);
//		response.setContentType("text/html;charset=UTF-8");
//		
////		teacherService.addTeacher(teacher);
//		Boolean boolean1 = teacherService.addTeacher(teacher);
//		String message;
//		if (boolean1) {
////			message = "{\"statusCode\":\"200\", \"message\":\"操作成功\", "
////					+ "\"navTabId\":\"navNewsLi\", \"forwardUrl\":\"\", "
////					+ "\"callbackType\":\"closeCurrent\"}"
//		    message = "{\"statusCode\":\"200\", \"message\":\"操作成功\", \"navTabId\":\"teacherlist\", \"callbackType\":\"closeCurrent\"}";
//		}else {
//			message = "{\"statusCode\":\"300\", \"message\":\"操作失败\"}";
//		}
//		response.getWriter().print(message);
		//从前台获取数据
		String idString = request.getParameter("id");
		int id = Integer.valueOf(idString);
		//调用FindteacherById()方法得到一个对象
		Teacher teacher = teacherService.findTeacherById(id);
		request.setAttribute("teacher", teacher);
		request.getRequestDispatcher("resource/common/teacher_add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		TeacherService teacherService =  new TeacherService();
		String idString = request.getParameter("id");
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String sex = request.getParameter("sex");
		
		Teacher teacher = new Teacher();
		teacher.setName(name);
		teacher.setPhone(phone);
		teacher.setSex(sex);
		response.setContentType("text/html;charset=UTF-8");
		Boolean boolean1 = false;
		if (idString != "" && idString != null) {
			teacher.setId(Integer.valueOf(idString).longValue());
			boolean1 = teacherService.editTeacher(teacher);
		}
		else {
			boolean1 = teacherService.addTeacher(teacher);
		}
		
//		Boolean boolean1 = teacherService.addTeacher(teacher);
		String message;
		if (boolean1) {

		    message = "{\"statusCode\":\"200\", \"message\":\"操作成功\", \"navTabId\":\"teacherlist\", \"callbackType\":\"closeCurrent\"}";
		}else {
			message = "{\"statusCode\":\"300\", \"message\":\"操作失败\"}";
		}
		response.getWriter().print(message);
	}

}

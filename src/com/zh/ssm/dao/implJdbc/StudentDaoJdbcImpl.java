package com.zh.ssm.dao.implJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zh.ssm.bean.Student;
import com.zh.ssm.dao.StudentDao;

public class StudentDaoJdbcImpl implements StudentDao {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String conn = "jdbc:mysql://localhost:3306/scs?CharSet=utf8&useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
	private static final String username = "root";
	private static final String password = "123456";
	
	public List<Student> findAllStudent() {
		
		List<Student> list = new ArrayList<>();
		
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn,username,password);
			String sql = "SELECT id, name, age, score, sex FROM scs.student;";
			PreparedStatement pStatement = connection.prepareStatement(sql);
//			pStatement.setString(1, userName);
//			System.out.println(pStatement.toString());
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
//				System.out.println("name "+ resultSet.getString(2) +"password " + resultSet.getString(3));
				Student student = new Student();
//				“ ”中内容对于数据库表中内容
				student.setId(resultSet.getLong("id"));
				student.setName(resultSet.getString("name"));
				student.setAge(resultSet.getString("age"));
				student.setScore(resultSet.getString("score"));
				student.setSex(resultSet.getString("sex"));
				
				list.add(student);
				}
			} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			}
		return list; 
	}
	
	public static void main(String[] args) {
		StudentDaoJdbcImpl studentDaoJdbcImpl = new StudentDaoJdbcImpl();
		List<Student> list = new ArrayList<>();
		list = studentDaoJdbcImpl.findAllStudent();
		
		for (Student student : list) {
			System.out.println(student.getId() + " " + student.getName());
		}
	}

} 

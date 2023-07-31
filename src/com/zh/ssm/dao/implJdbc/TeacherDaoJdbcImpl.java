package com.zh.ssm.dao.implJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;

import com.zh.ssm.bean.BasePage;
import com.zh.ssm.bean.Teacher;
import com.zh.ssm.dao.TeacherDao;

public class TeacherDaoJdbcImpl implements TeacherDao{
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String conn = "jdbc:mysql://localhost:3306/scs?CharSet=utf8&useSSL=false&useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
	private static final String username = "root";
	private static final String password = "123456";

	public List<Teacher> findAllTeacher() {
		
		List<Teacher> list = new ArrayList<>();
		
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn,username,password);
			String sql = "SELECT id, name, phone, sex FROM scs.teacher;";
			PreparedStatement pStatement = connection.prepareStatement(sql);
//			pStatement.setString(1, userName);
//			System.out.println(pStatement.toString());
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				Teacher teacher = new Teacher();
//				“ ”中内容对于数据库表中内容
				teacher.setId(resultSet.getLong("id"));
				teacher.setName(resultSet.getString("name"));
				teacher.setPhone(resultSet.getString("phone"));
				teacher.setSex(resultSet.getString("sex"));
				
				list.add(teacher);
				
				}
			} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			}
		
		return list;
	}
	
	
	
	public static void main(String[] args) {
		TeacherDaoJdbcImpl teacherDaoJdbcImpl = new TeacherDaoJdbcImpl();
//		Teacher teacher = new Teacher();
		
		
		//数据库中在相应字段中删除内容
//		Boolean boolean1 = teacherDaoJdbcImpl.deleteTeacherById((long) 20);
		//查询分页
//		BasePage basePage = new BasePage();
//		basePage.setCurrentPage(2);
//		basePage.setNumPerPage(5); 
//		List<Teacher> list = teacherDaoJdbcImpl.findAllTeacher(basePage);
//		System.out.println("teacher totalCount = " + basePage.getTotalCount());
//	    for (Teacher teacher : list)
//	    {
//	    	System.out.println(teacher.getId() + " " + teacher.getName() );
//	    }
		
		//数据库中在相应字段中插入内容
//		teacher.setName("admin");
//		teacher.setPhone("654321");
//		teacher.setSex("男");
		
		//输出测试
//		Boolean boolean1 = teacherDaoJdbcImpl.addTeacher(teacher);
//		System.out.println(boolean1);
		
		List<Teacher> list = new ArrayList<>();
//		list = teacherDaoJdbcImpl.findAllTeacher();
		
////		System.out.println(teacher.getName());
//	
		String sex = "男";
		list = teacherDaoJdbcImpl.findAllTeacher("", sex, "");
		for (Teacher teacher1 : list) {
			System.out.println(teacher1.getId() + ""+teacher1.getSex()+""+ teacher1.getName());
		}
		
		//测试按id的修改方法
//		teacher.setId((long) 1);
//		teacher.setName("adsfs");
//		teacher.setPhone("12348888");
//		teacher.setSex("女");
//		Boolean boolean1 = teacherDaoJdbcImpl.editTeacher(teacher);
//		System.out.println(boolean1);
		//测试按id的查询方法
//		teacher = teacherDaoJdbcImpl.findTeacherById(6);
//		System.out.println(teacher.getName());
//		System.out.println(teacher.getPhone());
//		System.out.println(teacher.getSex());
	}

	@Override
	public List<Teacher> findAllTeacher(String name, String sex, String phone) {
		
//		去掉首位空格
		name = name == null ? "" : name.trim();
		sex = sex == null ? "" : sex;
		phone = phone == null ? "" : phone.trim();
		
		String sql = "SELECT id, name, phone, sex FROM scs.teacher where 1=1";
		if (name != "") {
//			注意and前面有一个空格
			sql = sql + " and name = '" + name + "'";
		}
		sql += sex == "" ? "" : " and sex = '" + sex + "'";
		sql += phone == "" ? "" : " and phone = '" + phone + "'";
//		sql += name == "" ? "" : " and sex = " + sex;
//		return null;
		
        List<Teacher> list = new ArrayList<>();
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn,username,password);
//			String sql = "SELECT id, name, phone, sex FROM scs.teacher;";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				Teacher teacher = new Teacher();
//				“ ”中内容对于数据库表中内容
				teacher.setId(resultSet.getLong("id"));
				teacher.setName(resultSet.getString("name"));
				teacher.setPhone(resultSet.getString("phone"));
				teacher.setSex(resultSet.getString("sex"));
				
				list.add(teacher);
				
				}
			} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			}
		
		return list;
	}



	@Override
	public boolean addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
//		 List<Teacher> list = new ArrayList<>();
		Boolean boolean1 = false;
			try {
				Class.forName(driver);//注册驱动
				Connection connection = DriverManager.getConnection(conn,username,password);//获得链接
				String sql = "INSERT INTO scs.teacher (name, phone, sex) VALUES(?, ?, ?);";
				PreparedStatement pStatement = connection.prepareStatement(sql);
//				pStatement.setInt(1, teacher.getId());//int为数据库字段类型，1为索引值位置
				pStatement.setString(1, teacher.getName());
				pStatement.setString(2, teacher.getPhone());
				pStatement.setString(3, teacher.getSex());
				
//				System.out.println(pStatement.toString());//测试sql语句是否错误
				
//				boolean1 = pStatement.execute();
				pStatement.execute();
				boolean1 = pStatement.getUpdateCount() == 1 ? true : false;
//				while (resultSet.next()) {
//					Teacher teacher = new Teacher();
////					“ ”中内容对于数据库表中内容
//					teacher.setId(resultSet.getLong("id"));
//					teacher.setName(resultSet.getString("name"));
//					teacher.setPhone(resultSet.getString("phone"));
//					teacher.setSex(resultSet.getString("sex"));
//					
//					list.add(teacher);
//					
//					}
				} 
			catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				}
		return boolean1;
	}



	@Override
	public Teacher findTeacherById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT id, name, phone, sex FROM scs.teacher where id=?";

		
//        List<Teacher> list = new ArrayList<>();
		Teacher teacher = new Teacher();
		//创建驱动
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn,username,password);
//			String sql = "SELECT id, name, phone, sex FROM scs.teacher;";
			PreparedStatement pStatement = connection.prepareStatement(sql);
//			ResultSet resultSet = pStatement.executeQuery();
			pStatement.setInt(1, id);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
//				Teacher teacher = new Teacher();
//				“ ”中内容对于数据库表中内容
				teacher.setId(resultSet.getLong("id"));
				teacher.setName(resultSet.getString("name"));
				teacher.setPhone(resultSet.getString("phone"));
				teacher.setSex(resultSet.getString("sex"));
				
//				list.add(teacher);
				
				}
			} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			}
		
		return teacher;
	}



	@Override
	public Boolean editTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		Boolean boolean1 = false;
		try {
			Class.forName(driver);//注册驱动
			Connection connection = DriverManager.getConnection(conn,username,password);//获得链接
			String sql = "UPDATE scs.teacher SET name=?, phone=?, sex=? WHERE id=?;";
			PreparedStatement pStatement = connection.prepareStatement(sql);
//			pStatement.setInt(1, teacher.getId());//int为数据库字段类型，1为索引值位置
			pStatement.setString(1, teacher.getName());
			pStatement.setString(2, teacher.getPhone());
			pStatement.setString(3, teacher.getSex());
			pStatement.setLong(4, teacher.getId());
			
//			System.out.println(pStatement.toString());//测试sql语句是否错误
			
//			boolean1 = pStatement.execute();
			pStatement.execute();
			boolean1 = pStatement.getUpdateCount() == 1 ? true : false;

			} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			}
	return boolean1;
	}



	@Override
	public Boolean deleteTeacherById(Long id) {
		// TODO Auto-generated method stub
		Boolean boolean1 = false;
		try {
			Class.forName(driver);//注册驱动
			Connection connection = DriverManager.getConnection(conn,username,password);//获得链接
			String sql = "DELETE FROM scs.teacher WHERE id=?;";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setLong(1, id);
			
//			System.out.println(pStatement.toString());
//			boolean1 = pStatement.execute();
			pStatement.execute();
			boolean1 = pStatement.getUpdateCount() == 1 ? true : false;

			} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			}
	return boolean1;
	}



	@Override
	public List<Teacher> findAllTeacher(BasePage basePage) {
		// TODO Auto-generated method stub
        List<Teacher> list = new ArrayList<>();
		
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn,username,password);
			String sql = "SELECT id, name, phone, sex FROM scs.teacher limit ?,?;";
			String sqlCount = "select count(*) from scs.teacher;";
			PreparedStatement pStatement = connection.prepareStatement(sqlCount);
			ResultSet resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				basePage.setTotalCount(resultSet.getInt(1));
			}
			
			
			pStatement = connection.prepareStatement(sql);
			//设置索引值
            pStatement.setInt(1, basePage.getStartIndex());
            pStatement.setInt(2, basePage.getNumPerPage());
            resultSet = pStatement.executeQuery();
            
//			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				Teacher teacher = new Teacher();
//				“ ”中内容对于数据库表中内容
				teacher.setId(resultSet.getLong("id"));
				teacher.setName(resultSet.getString("name"));
				teacher.setPhone(resultSet.getString("phone"));
				teacher.setSex(resultSet.getString("sex"));
				
				list.add(teacher);
				
				}
			} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			}
		
		return list;
	}

//	@Override
//	public void saveOrUpdate(Teacher teacher) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteById(Long id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Teacher findById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}

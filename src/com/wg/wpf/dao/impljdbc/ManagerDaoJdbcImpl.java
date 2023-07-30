package com.wg.wpf.dao.impljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wg.wpf.bean.BasePage;
import com.wg.wpf.bean.Manager;

import com.wg.wpf.dao.ManagerDao;

public class ManagerDaoJdbcImpl implements ManagerDao{
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String conn = "jdbc:mysql://localhost:3306/salarydata?CharSet=utf8&useSSL=false&useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
	private static final String username = "root";
	private static final String password = "123456";

	
	public List<Manager> findAllManager() {
		// TODO Auto-generated method stub
		
		List<Manager> list = new ArrayList<>();
		
		try {
			Class.forName(driver);//注册驱动
			Connection connection = DriverManager.getConnection(conn, username, password);
			String sql = "SELECT id, name, phone, sex, age, idcard, salary, insurance, bonus, tax, `position`, email FROM salarydata.manage;";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				Manager manager = new Manager();
				
//				“ ”中内容对于数据库表中内容
				manager.setId(resultSet.getLong("id"));
				manager.setName(resultSet.getString("name"));
				manager.setPhone(resultSet.getString("phone"));
				manager.setSex(resultSet.getString("sex"));
				manager.setAge(resultSet.getInt("age"));
				manager.setIdcard(resultSet.getString("idcard"));
				manager.setSalary(resultSet.getString("salary"));
				manager.setInsurance(resultSet.getString("insurance"));
				manager.setBonus(resultSet.getString("bonus"));
				manager.setTax(resultSet.getString("tax"));
				manager.setPosition(resultSet.getString("position"));
				manager.setEmail(resultSet.getString("email"));
					
				list.add(manager);
			}
		}
	catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		ManagerDaoJdbcImpl managerDaoJdbcImpl = new ManagerDaoJdbcImpl();
		Manager manager = new Manager();
		//查看数据测试
//		List<Manager> list = new ArrayList<>();
//		String position = "小组长";
//		list = managerDaoJdbcImpl.findAllManager("", "", "", "", "", "", "", "", "", position, "");
//		
//		
//		for (Manager manager1 : list) {
//			System.out.println(manager1.getAge() + manager1.getSalary());
//		}
		
		//测试增加数据
//		manager.setName("王老五");
//	    manager.setAge(12);
//	    manager.setPhone("155888666");
//	    manager.setSex("女");
//	    manager.setIdcard("452452425");
//	    manager.setSalary( "5000");
//	    manager.setBonus("3000");
//	    manager.setInsurance("500");
//	    manager.setTax( "5000");
//	    manager.setPosition("职员");
//	    manager.setEmail("aaa@bbb.com");
	    
	    //测试查找数据
	    manager = managerDaoJdbcImpl.findManagerById(13);
	    System.out.println(manager.getName());
	    System.out.println(manager.getPhone());
	    System.out.println(manager.getSex());
	    System.out.println(manager.getIdcard());
	    System.out.println(manager.getSalary());
	    System.out.println(manager.getInsurance());
	    System.out.println(manager.getBonus());
	    System.out.println(manager.getTax());
	    System.out.println(manager.getPosition());
	    System.out.println(manager.getEmail());
	    
	    //测试增加数据
	    Boolean boolean1 = managerDaoJdbcImpl.addManager(manager);
//	    System.out.println(boolean1);

		//测试删除数据库中对应id字段的内容
//		Boolean boolean1 = managerDaoJdbcImpl.deleteManagerById((long) 5);
//	    System.out.println(boolean1);
	}

	@Override
	public List<Manager> findAllManager(String name, String phone, String sex, String age, 
			String idcard, String salary, String insurance, String bonus,
              String tax, String position, String email) {
		// TODO Auto-generated method stub
		
//		去掉首位空格
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
		
		String sql = "SELECT id, name, phone, sex, age, idcard, salary, insurance, bonus, tax, `position`, email FROM salarydata.manage where 1=1";
		if (name != "") {
			sql = sql + " and name = '" + name + "'";
		}
		sql += name == "" ? "" : " and name = '" + name + "'";
		sql += phone == "" ? "" : " and phone = '" + phone + "'";
		sql += sex == "" ? "" : " and sex = '" + sex + "'";
		sql += age == "" ? "" : " and age = '" + age + "'";
		sql += idcard == "" ? "" : " and idcard = '" + idcard + "'";
		sql += salary == "" ? "" : " and salary = '" + salary + "'";
		sql += insurance == "" ? "" : " and insurance = '" + insurance + "'";
		sql += bonus == "" ? "" : " and bonus = '" + bonus + "'";
		sql += tax == "" ? "" : " and tax = '" + tax + "'";
		sql += position == "" ? "" : " and position = '" + position + "'";
		sql += email == "" ? "" : " and email = '" + email + "'";
		
        List<Manager> list = new ArrayList<>();
		
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, username, password);
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				Manager manager = new Manager();
				
//				“ ”中内容对于数据库表中内容
				manager.setId(resultSet.getLong("id"));
				manager.setName(resultSet.getString("name"));
				manager.setPhone(resultSet.getString("phone"));
				manager.setSex(resultSet.getString("sex"));
				manager.setAge(resultSet.getInt("age"));
				manager.setIdcard(resultSet.getString("idcard"));
				manager.setSalary(resultSet.getString("salary"));
				manager.setInsurance(resultSet.getString("insurance"));
				manager.setBonus(resultSet.getString("bonus"));
				manager.setTax(resultSet.getString("tax"));
				manager.setPosition(resultSet.getString("position"));
				manager.setEmail(resultSet.getString("email"));
				
				list.add(manager);
			}
		}
	catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean addManager(Manager manager) {
		// TODO Auto-generated method stub
		Boolean boolean1 = false;
		
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, username, password);
			String sql = "INSERT INTO salarydata.manage (name, phone, sex, age, idcard, salary, insurance, bonus, tax, `position`, email) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			
			pStatement.setString(1, manager.getName());
			pStatement.setString(2, manager.getPhone());
			pStatement.setString(3, manager.getSex());
			pStatement.setInt(4, manager.getAge());
			pStatement.setString(5, manager.getIdcard());
			pStatement.setString(6, manager.getSalary());
			pStatement.setString(7, manager.getInsurance());
			pStatement.setString(8, manager.getBonus());
			pStatement.setString(9, manager.getTax());
			pStatement.setString(10, manager.getPosition());
			pStatement.setString(11, manager.getEmail());
			
			pStatement.execute();
			boolean1 = pStatement.getUpdateCount() == 1 ? true : false;

		}
	catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		
		return boolean1;
	
	}

	@Override
	public Manager findManagerById(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT id, name, phone, sex, age, idcard, salary, insurance, bonus, tax, `position`, email FROM salarydata.manage where id=?;";
		Manager manager = new Manager();
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, username, password);
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			ResultSet resultSet = pStatement.executeQuery();
			
			while (resultSet.next()) {
				manager.setId(resultSet.getLong("id"));
				manager.setName(resultSet.getString("name"));
				manager.setPhone(resultSet.getString("phone"));
				manager.setSex(resultSet.getString("sex"));
				manager.setAge(resultSet.getInt("age"));
				manager.setIdcard(resultSet.getString("idcard"));
				manager.setSalary(resultSet.getString("salary"));
				manager.setInsurance(resultSet.getString("insurance"));
				manager.setBonus(resultSet.getString("bonus"));
				manager.setTax(resultSet.getString("tax"));
				manager.setPosition(resultSet.getString("position"));
				manager.setEmail(resultSet.getString("email"));

			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return manager;
	}

	@Override
	public boolean editManager(Manager manager) {
		// TODO Auto-generated method stub
		Boolean boolean1 = false;
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, username, password);
			String sql = "UPDATE salarydata.manage SET name=?, phone=?, sex=?, age=?, idcard=?, salary=?, insurance=?, bonus=?, tax=?, `position`=?, email=? WHERE id=?;";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, manager.getName());
			pStatement.setString(2, manager.getPhone());
			pStatement.setString(3, manager.getSex());
			pStatement.setInt(4, manager.getAge());
			pStatement.setString(5, manager.getIdcard());
			pStatement.setString(6, manager.getSalary());
			pStatement.setString(7, manager.getInsurance());
			pStatement.setString(8, manager.getBonus());
			pStatement.setString(9, manager.getTax());
			pStatement.setString(10, manager.getPosition());
			pStatement.setString(11, manager.getEmail());
			pStatement.setLong(12, manager.getId());
			
			pStatement.execute();
			boolean1 = pStatement.getUpdateCount() == 1 ? true : false;
		    }
		    catch (SQLException | ClassNotFoundException e) {
		    	// TODO: handle exception
		    	e.printStackTrace();
		    }
	return boolean1;
	}

	@Override
	public Boolean deleteManagerById(Long id) {
		// TODO Auto-generated method stub
		Boolean boolean1 = false;
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, username, password);
			String sql = "DELETE FROM salarydata.manage WHERE id=?;";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setLong(1, id);
			
			pStatement.execute();
			boolean1 = pStatement.getUpdateCount() == 1 ? true : false;
		}
		catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return boolean1;
	}

	@Override
	public List<Manager> findAllManager(BasePage basePage) {
		// TODO Auto-generated method stub
		
        List<Manager> list = new ArrayList<>();
		
		try {
			Class.forName(driver);//注册驱动
			Connection connection = DriverManager.getConnection(conn, username, password);
			String sql = "SELECT id, name, phone, sex, age, idcard, salary, insurance, bonus, tax, `position`, email FROM salarydata.manage limit ?,?;";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			ResultSet resultSet = pStatement.executeQuery();
			
			if(resultSet.next()) {
				basePage.setTotalCount(resultSet.getInt(1));
			}
			
			pStatement = connection.prepareStatement(sql);
			//设置索引值
            pStatement.setInt(1, basePage.getStartIndex());
            pStatement.setInt(2, basePage.getNumPerPage());
            resultSet = pStatement.executeQuery();
			
			while (resultSet.next()) {
				Manager manager = new Manager();
				
//				“ ”中内容对于数据库表中内容
				manager.setId(resultSet.getLong("id"));
				manager.setName(resultSet.getString("name"));
				manager.setPhone(resultSet.getString("phone"));
				manager.setSex(resultSet.getString("sex"));
				manager.setAge(resultSet.getInt("age"));
				manager.setIdcard(resultSet.getString("idcard"));
				manager.setSalary(resultSet.getString("salary"));
				manager.setInsurance(resultSet.getString("insurance"));
				manager.setBonus(resultSet.getString("bonus"));
				manager.setTax(resultSet.getString("tax"));
				manager.setPosition(resultSet.getString("position"));
				manager.setEmail(resultSet.getString("email"));
					
				list.add(manager);
			}
		}
	catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return list;
	}


}

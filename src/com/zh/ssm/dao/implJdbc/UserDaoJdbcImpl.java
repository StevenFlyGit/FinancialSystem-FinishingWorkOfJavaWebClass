package com.zh.ssm.dao.implJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.zh.ssm.bean.Users;
import com.zh.ssm.dao.UserDao;

//import sun.security.util.Password;

public class UserDaoJdbcImpl implements UserDao {
//	private static final String string = null;
	private static final String driver = "com.mysql."
			+ ""
			+ "jdbc.Driver";
	private static final String conn = "jdbc:mysql://localhost:3306/scs?CharSet=utf8&useSSL=false&useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
	private static final String username = "root";
	private static final String password = "123456";
	@Override
	public Users findUsersByName(String userName) {
		
		//1.准备驱动
		Users users = null;
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn,username,password);
			String sql = "SELECT id, name, password, realname, age, sex, email, dtype  FROM scs.users WHERE name=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, userName);
			System.out.println(pStatement.toString());
			ResultSet resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("name "+ resultSet.getString(2) +"password " + resultSet.getString(3));
				users = new Users();
				users.setId(resultSet.getLong("id"));
				users.setName(resultSet.getString("name"));
				users.setRealname(resultSet.getString("realname"));
				users.setPassword(resultSet.getString("password"));
				users.setAge(resultSet.getInt("age"));
				users.setSex(resultSet.getString("sex"));
				users.setEmail(resultSet.getString("email"));
				users.setDtype(resultSet.getString("dtype"));
				}
			} 
		catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			}
	return users;

	}
	public static void main(String[] args) {
    	UserDaoJdbcImpl userDaoJbdcImpl = new UserDaoJdbcImpl();
//		userDaoJbdcImpl.findUsersByName(String);
    	Users users = userDaoJbdcImpl.findUsersByName("admin");
    	System.out.println(users.getName()); 
    	System.out.println(users.getPassword());
    }
}

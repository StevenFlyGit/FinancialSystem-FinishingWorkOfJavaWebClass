package com.wg.wpf.dao.impljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wg.wpf.bean.Workers;
import com.wg.wpf.dao.WorkerDao;

public class WorkerDaoJdbcImpl implements WorkerDao{
	
	private static final String driver = "com.mysql."
			+ ""
			+ "jdbc.Driver";
	private static final String conn = "jdbc:mysql://localhost:3306/salarydata?CharSet=utf8&useSSL=false&useUnicode=true&characterEncoding=utf-8&autoReconnect=true";
	private static final String username = "root";
	private static final String password = "123456";

	

	@Override
	public Workers findWorkersByName(String workerName) {
		// TODO Auto-generated method stub
		
		//1.准备驱动
		Workers workers = null;
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(conn, username, password);
			//sql 语句
			String sql = "SELECT id, name, password, realname, age, sex, email, dtype, phone FROM salarydata.workers WHERE name=?";
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, workerName);
//			System.out.println(pStatement.toString());
			ResultSet resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				//输出数据测试
				System.out.println("name "+ resultSet.getString(2) +"password " + resultSet.getString(3));
				//获得数据库中的相应数据
				workers = new Workers();
				workers.setId(resultSet.getLong("id"));
				workers.setName(resultSet.getString("name"));
				workers.setRealname(resultSet.getString("realname"));
				workers.setPassword(resultSet.getString("password"));
				workers.setAge(resultSet.getInt("age"));
				workers.setSex(resultSet.getString("sex"));
//				workers.setSalary(resultSet.getFloat("salary"));
				workers.setPhone(resultSet.getString("phone"));
				workers.setEmail(resultSet.getString("email"));
				workers.setDtype(resultSet.getString("dtype"));
			    }
		}
		catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return workers;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorkerDaoJdbcImpl workerDaoJdbcImpl = new WorkerDaoJdbcImpl();
		Workers workers = workerDaoJdbcImpl.findWorkersByName("steven");
//		System.out.println(workers.getName());
//		System.out.println(workers.getPassword());
	}

}

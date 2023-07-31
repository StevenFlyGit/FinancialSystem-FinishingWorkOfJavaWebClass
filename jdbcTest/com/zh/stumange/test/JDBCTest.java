package com.zh.stumange.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

public class JDBCTest {

	@Test
	public void test() throws ClassNotFoundException, SQLException {
		//1.准备驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.取得连接
		Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/scs?CharSet=utf8&useUnicode=true&characterEncoding=utf-8&autoReconnect=true", "root", "123456");
		//3.准备sql
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement("INSERT INTO scs.teacher ( name, phone, sex) VALUES(?, ?, ?)");
		ps.setString(1, "李四");
		ps.setString(2, "123213");
		ps.setString(3, "女");
		int result = ps.executeUpdate();
		System.out.printf("插入了%s个数据", result);
      conn.close();
	}

}

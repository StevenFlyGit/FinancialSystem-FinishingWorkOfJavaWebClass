package com.zh.ssm.service;

import com.zh.ssm.bean.Users;
import com.zh.ssm.dao.UserDao;
import com.zh.ssm.dao.implJdbc.UserDaoJdbcImpl;

public class UserService {
	
	private UserDao userDao = new UserDaoJdbcImpl();

//	public Users findUserByName(String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public Users findUserByName(String name) {
		return userDao.findUsersByName(name);
	}
}

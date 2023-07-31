package com.zh.ssm.dao;

import com.zh.ssm.bean.Users;

public interface UserDao {
	Users findUsersByName(String name);
}

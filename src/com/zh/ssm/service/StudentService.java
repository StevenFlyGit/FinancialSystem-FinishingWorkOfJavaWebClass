package com.zh.ssm.service;

import com.zh.ssm.dao.StudentDao;
import com.zh.ssm.dao.implJdbc.StudentDaoJdbcImpl;

public class StudentService {
	StudentDao studentDao = new StudentDaoJdbcImpl();
}

package com.zh.ssm.service;

import java.util.List;

import com.zh.ssm.bean.BasePage;
import com.zh.ssm.bean.Teacher;
import com.zh.ssm.dao.TeacherDao;
import com.zh.ssm.dao.implJdbc.TeacherDaoJdbcImpl;

public class TeacherService {
	private TeacherDao teacherDao = new TeacherDaoJdbcImpl();
	
	public List<Teacher> findAllTeacher(){
		List<Teacher> list = teacherDao.findAllTeacher();
		return list;
//		return this.teacherDao.findAllTeacher();
	}

	public List<Teacher> findAllTeacher(String name, String sex, String phone) {
//		return this.teacherDao.findAllTeacher(name, sex, phone);
		return teacherDao.findAllTeacher(name, sex, phone);
	}

	public boolean addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.addTeacher(teacher);
	}

	public Teacher findTeacherById(int id) {
		// TODO Auto-generated method stub
		return teacherDao.findTeacherById(id);
	}

	public Boolean editTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.editTeacher(teacher);
	}

	public Boolean deleteTeacherById(Long id) {
		// TODO Auto-generated method stub
		return teacherDao.deleteTeacherById(id);
	}

	public List<Teacher> findAllTeacher(BasePage basePage) {
		// TODO Auto-generated method stub
		return teacherDao.findAllTeacher(basePage);
	}



//	public void saveOrUpdate(Teacher teacher) {
//		this.teacherDao.saveOrUpdate(teacher);
//	}
//
//	public void deleteById(Long id) {
//		this.teacherDao.deleteById(id);
//	}
//
//	public Teacher findTeacherById(Long id) {
//		return this.teacherDao.findById(id);
//	}
}

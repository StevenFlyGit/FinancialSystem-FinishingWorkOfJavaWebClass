package com.zh.ssm.dao;

import java.util.List;

import com.zh.ssm.bean.Teacher;

public interface TeacherDao {
	List<Teacher> findAllTeacher();
//	查找老师信息
	List<Teacher> findAllTeacher(String name, String sex, String phone);
	boolean addTeacher(Teacher teacher);
	Teacher findTeacherById(int id);
	Boolean editTeacher(Teacher teacher);
	Boolean deleteTeacherById(Long id);

//	public List<Teacher> findAllTeacher(String name, String sex, String phone);

//	public void saveOrUpdate(Teacher teacher);
//
//	public void deleteById(Long id);
//
//	public Teacher findById(Long id);
	
}

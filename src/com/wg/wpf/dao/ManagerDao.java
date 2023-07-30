package com.wg.wpf.dao;

import java.util.List;

import com.wg.wpf.bean.BasePage;
import com.wg.wpf.bean.Manager;

public interface ManagerDao {

	List<Manager> findAllManager();

//	List<Manager> findAllManager(String name, String sex, String phone, Float salary, String age, String realname);

//	List<Manager> findAllManager(String name, String sex, String phone, String salary, String age, String realname);

	boolean addManager(Manager manager);

//	List<Manager> findAllManager(String name, String sex, String phone, String salary, String age, String realname, String position);

	Manager findManagerById(int id);

	boolean editManager(Manager manager);

	List<Manager> findAllManager(String name, String phone, String sex, String age, String idcard, String salary,
			String insurance, String bonus, String tax, String position, String email);

	Boolean deleteManagerById(Long id);

	List<Manager> findAllManager(BasePage basePage);


}

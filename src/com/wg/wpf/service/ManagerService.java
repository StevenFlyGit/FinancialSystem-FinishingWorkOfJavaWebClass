package com.wg.wpf.service;

import java.util.List;

import com.wg.wpf.bean.BasePage;
import com.wg.wpf.bean.Manager;
import com.wg.wpf.dao.ManagerDao;
import com.wg.wpf.dao.impljdbc.ManagerDaoJdbcImpl;

public class ManagerService {
	private ManagerDao managerDao = new ManagerDaoJdbcImpl();
	
	public List<Manager> findAllManager() {
		List<Manager> list = managerDao.findAllManager();
		return list;
	}
	
//	public List<Manager> findAllManager(String name, String sex, String phone, Float salary, String age, String realname) {
//		return managerDao.findAllManager(name, sex, phone, salary, age, realname);
//	}
	public List<Manager> findAllManager(String name,  String phone, String sex, String age, String idcard, String salary, String insurance, String bonus,
            String tax, String position, String email) {
		return managerDao.findAllManager(name, phone, sex, age, idcard, salary, insurance, bonus, tax, position, email);
	}
	
	public boolean addManager(Manager manager) {
		return managerDao.addManager(manager);
	}
	
	public Manager findManagerById(int id) {
		return managerDao.findManagerById(id);
	}
	
	public Boolean editManager(Manager manager) {
		return managerDao.editManager(manager);
	}
	
	public Boolean deleteManagerById(Long id) {
		return managerDao.deleteManagerById(id);
	}
	
	public List<Manager> findAllManager(BasePage basePage) {
		return managerDao.findAllManager(basePage);
	}
}

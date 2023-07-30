package com.wg.wpf.service;

import com.wg.wpf.bean.Workers;
import com.wg.wpf.dao.WorkerDao;
import com.wg.wpf.dao.impljdbc.WorkerDaoJdbcImpl;

public class WorkerService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private WorkerDao workerDao = new WorkerDaoJdbcImpl();

	public Workers findWorkerByName(String name) {
		// TODO Auto-generated method stub
		return workerDao.findWorkersByName(name);
	}

}

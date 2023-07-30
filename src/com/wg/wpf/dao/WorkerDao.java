package com.wg.wpf.dao;

import com.wg.wpf.bean.Workers;

public interface WorkerDao {

	Workers findWorkersByName(String name);

}

package com.online.dao;

import com.online.domain.LogDomain;
import com.online.domain.Page;

public interface LogDao {
	
	void add(LogDomain logDomain);
	Page<LogDomain> allLog(int page,int rows);
}

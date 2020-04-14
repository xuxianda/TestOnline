package com.online.service;

import com.online.domain.LogDomain;
import com.online.domain.Page;

public interface LogService {
	void add(LogDomain logDomain);
	Page<LogDomain> allLog(int page,int rows);
}

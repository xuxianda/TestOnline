package com.online.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.LogDao;
import com.online.domain.LogDomain;
import com.online.domain.Page;
import com.online.service.LogService;
@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private LogDao logDao;
		
	@Override
	public void add(LogDomain logDomain) {
			logDao.add(logDomain);
	}

	@Override
	public Page<LogDomain> allLog(int page, int rows) {
		return logDao.allLog(page, rows);
	}

}

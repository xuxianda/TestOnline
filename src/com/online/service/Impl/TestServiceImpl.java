package com.online.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.TestDao;
import com.online.domain.Page;
import com.online.domain.TestDomain;
import com.online.service.TestService;
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao testDao;
	
	@Override
	public List<TestDomain> find(int indexpage, int pagesize) {
		return testDao.find(indexpage, pagesize);
	}

	@Override
	public List<TestDomain> paperRank(String tname, int indexpage, int pagesize) {
		return testDao.paperRank(tname, indexpage, pagesize);
	}

	@Override
	public Page<TestDomain> findMy(int indexpage, int pagesize) {
		return testDao.findMy(indexpage, pagesize);
	}

}

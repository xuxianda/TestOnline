package com.online.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.StudentTestDao;
import com.online.domain.Page;
import com.online.domain.TestDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserTestDomain;
import com.online.service.StudentTestService;

@Service
public class StudentTestServiceImpl implements StudentTestService {
	@Autowired
	private StudentTestDao studentTestDao;

	@Override
	public Page<UserTestDomain> paperStudent(int tid, int indexpage, int pagesize) {
		return studentTestDao.paperStudent(tid, indexpage, pagesize);
	}

	@Override
	public Page<UserDomain> findIntegral(int indexpage, int pagesize) {
		return studentTestDao.findIntegral(indexpage, pagesize);
	}

	@Override
	public Page<UserDomain> firstIntegral(int page, int rows) {
		return studentTestDao.firstIntegral(page, rows);
	}

	@Override
	public Page<UserDomain> secondIntegral(int page, int rows) {
		return studentTestDao.secondIntegral(page, rows);
	}

	@Override
	public Page<UserDomain> lastIntegral(int page, int rows) {
		return studentTestDao.lastIntegral(page, rows);
	}

	@Override
	public Page<TestDomain> allTest(int page, int rows) {
		return studentTestDao.allTest(page, rows);
	}

	@Override
	public Page<TestDomain> testName(String tname, int page, int rows) {
		return studentTestDao.testName(tname, page, rows);
	}

	@Override
	public Page<UserTestDomain> getMyTest(int page, int rows, int uid) {
		return studentTestDao.getMyTest(page, rows, uid);
	}

	@Override
	public Page<UserTestDomain> paperStudent2(int tid, int indexpage, int pagesize) {
		return studentTestDao.paperStudent2(tid, indexpage, pagesize);
	}



}

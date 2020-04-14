package com.online.service;

import java.util.List;

import com.online.domain.Page;
import com.online.domain.TestDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserTestDomain;

public interface StudentTestService {
	Page<UserTestDomain> paperStudent(int tid,int indexpage,int pagesize);
	Page<UserDomain> findIntegral(int indexpage,int pagesize);
	Page<UserDomain> firstIntegral(int page,int rows);
	Page<UserDomain> secondIntegral(int page,int rows);
	Page<UserDomain> lastIntegral(int page,int rows);
	Page<TestDomain> allTest(int page,int rows);
	Page<TestDomain> testName(String tname,int page,int rows);
	Page<UserTestDomain> getMyTest(int page,int rows,int uid);
	Page<UserTestDomain> paperStudent2(int tid, int indexpage, int pagesize);
}

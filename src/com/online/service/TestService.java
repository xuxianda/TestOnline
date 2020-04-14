package com.online.service;

import java.util.List;

import com.online.domain.Page;
import com.online.domain.TestDomain;

public interface TestService {

	List<TestDomain> find(int indexpage, int pagesize);

	List<TestDomain> paperRank(String tname, int indexpage, int pagesize);
	Page<TestDomain> findMy(int indexpage,int pagesize);
}

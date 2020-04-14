package com.online.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.IPaperstuDao;
import com.online.dao.Impl.IPaperstuDaoImpl;
import com.online.domain.TestDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserTestDomain;
import com.online.service.IPaperstuService;

@Service
public class PaperstuServiceImpl implements IPaperstuService{

	@Autowired
	private IPaperstuDao stuDao;
	
	public void stuDaoImpl(IPaperstuDao stuDao) {
		
		this.stuDao = stuDao;
	}
	
	
	@Override
	public List<TestDomain> stuTestQueryAll() {
		
		return stuDao.stuTestQueryAll();
	}

	@Override
	public List<TestDomain> stuTypeQueryAll(String name) {
		
		return stuDao.stuTypeQueryAll(name);
	}

	@Override
	public List<TestDomain> stuNameQueryAll(String name) {
		
		return stuDao.stuNameQueryAll(name);
	}
	
	
	@Override
	public List<UserDomain> queryUser() {
		
		return stuDao.queryUser();
		
	}
	
	@Override
	public List<UserTestDomain> queryTestToday(){
		
		return stuDao.queryTestToday();
		
	}
	
	@Override
	public List<TestDomain> queryTestUser(UserDomain user){
		
		return stuDao.queryTestUser(user);
		
	}
	
	@Override
	public int updateUser(UserDomain user) {
		
		return stuDao.updateUser(user);
		
	}
	
	
	@Override
	public List<TestDomain> testNotQuery() {
		
		return stuDao.testNotQuery();
	}
	
	
	@Override
	public List<UserDomain> queryUserState(){
		
		return stuDao.queryUserState();
	}
	
	
	
	
	
	

}

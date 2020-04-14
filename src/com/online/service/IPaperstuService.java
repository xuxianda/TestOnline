package com.online.service;

import java.util.List;

import com.online.domain.TestDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserTestDomain;

public interface IPaperstuService {
	
	/**
	 * 学员默认查询所有试卷
     */
	
	List<TestDomain> stuTestQueryAll();
	
	/**
	 * 按科目查询试卷
     */
	List<TestDomain> stuTypeQueryAll(String name);
	
	/**
	 * 按试卷名模糊查询试卷
     */
	List<TestDomain> stuNameQueryAll(String name);
	
	/**
	 * 首页查询用户数量
     */
	List<UserDomain> queryUser();
	
	/**
	 * 首页查询今日考试人数
     */
	List<UserTestDomain> queryTestToday();
	
	
	/**
	 * 查询用户个人考试记录
     */
	List<TestDomain> queryTestUser(UserDomain user);
	
	
	/**
	 * 修改用户个人信息
     */
	int updateUser(UserDomain user);
	
	/**
	 * 查询所有未审核的试卷
     */
	List<TestDomain> testNotQuery();


	/**
	 * 查询所有未审核的用户
     */
	List<UserDomain> queryUserState();
	
	
	
	
}

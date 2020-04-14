package com.online.dao;

import java.util.List;

import com.online.domain.Page;
import com.online.domain.TestDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserTestDomain;

public interface StudentTestDao {
	
	/**
	 * 查询所有试卷
	 * @return
	 */
	Page<TestDomain> allTest(int page,int rows);
	
	/**
	 * 根据试卷名查询试卷
	 * @param tname
	 * @param page
	 * @param rows
	 * @return
	 */
	Page<TestDomain> testName(String tname,int page,int rows);
	
	/**
	 * 根据试卷id查询考过该试卷的学生
	 * @param tid 试卷id
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return list
	 */
	Page<UserTestDomain> paperStudent(int tid,int indexpage,int pagesize);
	
	/**
	 * 积分排名，从高到低
	 * @param indexpage
	 * @param pagesize
	 * @return
	 */
	Page<UserDomain> findIntegral(int indexpage,int pagesize);
	
	/**
	 * 查询0-999的积分排名
	 * @param page 页数
	 * @param rows 每页显示的条数
	 * @return list
	 */
	Page<UserDomain> firstIntegral(int page,int rows);
	
	/**
	 * 查询1000-2999的积分排名
	 * @param page 页数
	 * @param rows 每页显示的条数
	 * @return list
	 */
	Page<UserDomain> secondIntegral(int page,int rows);
	
	/**
	 * 查询3000+的积分排名
	 * @param page 页数
	 * @param rows 每页显示的条数
	 * @return list
	 */
	Page<UserDomain> lastIntegral(int page,int rows);
	
	/**
	 * 查询登录用户考过的试卷
	 * @param page
	 * @return
	 */
	Page<UserTestDomain> getMyTest(int page,int rows,int uid);
	
	
	Page<UserTestDomain> paperStudent2(int tid,int indexpage,int pagesize);
}

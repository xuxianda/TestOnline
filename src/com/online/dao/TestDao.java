package com.online.dao;

import java.util.List;

import org.nutz.dao.Dao;

import com.online.domain.Page;
import com.online.domain.TestDomain;
/**
 * 试卷dao层
 * @author lxh
 *
 */
public interface TestDao{
	
	/**
	 * 查询所有试卷
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return list集合
	 */
	List<TestDomain> find(int indexpage,int pagesize);
	/**
	 * 查询所有已审核试卷
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return list集合
	 */
	Page<TestDomain> findMy(int indexpage,int pagesize);
	/** 
	 * 根据试卷名，做模糊查询试卷
	 * @param tname 试卷名
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return list集合
	 */
	List<TestDomain> paperRank(String tname,int indexpage,int pagesize);
}

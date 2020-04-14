package com.online.dao;

import java.util.List;

import com.online.domain.Page;
import com.online.domain.SubjectDomain;

public interface SubjectDao {
	/**
	 * 查询所有科目
	 * @return
	 */
	Page<SubjectDomain> findAll(int page, int rows);
	
	List<SubjectDomain> findAll2();
	/**
	 * 新增科目
	 * @param domain
	 * @return
	 */
	public boolean add(SubjectDomain domain);
	/**
	 * 修改
	 * @param domain
	 * @return
	 */
	public boolean update(SubjectDomain domain) ;
}

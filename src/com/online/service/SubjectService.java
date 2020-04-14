package com.online.service;

import java.util.List;

import com.online.domain.Page;
import com.online.domain.SubjectDomain;

public interface SubjectService {
	
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

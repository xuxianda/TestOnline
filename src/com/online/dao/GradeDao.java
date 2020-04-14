package com.online.dao;

import java.util.List;

import com.online.domain.GradeDomain;

public interface GradeDao {
	/**
	 * 查询所有等级
	 * @return list
	 */
	List<GradeDomain> findAll();
}

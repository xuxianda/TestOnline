package com.online.dao;

import java.util.List;

import com.online.domain.QuestionTypeDomain;

public interface QuestionTypeDao {
	/**
	 * 查询所有题目类型
	 * @return
	 */
	List<QuestionTypeDomain> findAll();
}

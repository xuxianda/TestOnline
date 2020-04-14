package com.online.dao.Impl;

import java.util.List;

import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.QuestionTypeDao;
import com.online.domain.QuestionTypeDomain;
@Repository
public class QuestionTypeDaoImpl implements QuestionTypeDao {
	
	@Autowired
	private NutDao nutDao;
	
	@Override
	public List<QuestionTypeDomain> findAll() {
		return nutDao.query(QuestionTypeDomain.class, null);
	}

}

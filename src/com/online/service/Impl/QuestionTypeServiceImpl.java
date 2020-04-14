package com.online.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.QuestionTypeDao;
import com.online.domain.QuestionTypeDomain;
import com.online.service.QuestionTypeService;
@Service
public class QuestionTypeServiceImpl implements QuestionTypeService {

	@Autowired
	private QuestionTypeDao questionTypeDao;
	
	@Override
	public List<QuestionTypeDomain> findAll() {
		return questionTypeDao.findAll();
	}

}

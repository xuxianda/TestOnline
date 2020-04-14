package com.online.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.QuestionsSubjectDao;
import com.online.domain.QuestionsSubjectDomain;
import com.online.service.QuestionsSubjectService;
@Service
public class QuestionsSubjectServiceImpl implements QuestionsSubjectService {
	@Autowired
	private QuestionsSubjectDao questionsSubjectDao;
	
	@Override
	public boolean insert(QuestionsSubjectDomain questionsSubjectDomain) {
		return questionsSubjectDao.insert(questionsSubjectDomain)!=null;
	}

	@Override
	public boolean deleteOrUpdate(QuestionsSubjectDomain questionsSubjectDomain) {
		return questionsSubjectDao.deleteOrUpdate(questionsSubjectDomain)!=null;
	}

}

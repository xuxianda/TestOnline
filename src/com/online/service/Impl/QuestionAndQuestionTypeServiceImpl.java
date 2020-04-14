package com.online.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.QuestionsAndQuestionTypeDao;
import com.online.domain.QuestionsAndQuestionsTypeDomain;
import com.online.service.QuestionAndQuestionTypeService;
@Service
public class QuestionAndQuestionTypeServiceImpl implements QuestionAndQuestionTypeService{
	@Autowired
	private QuestionsAndQuestionTypeDao questionAndQuestionTypeDao;

	@Override
	public boolean insert(QuestionsAndQuestionsTypeDomain questionsAndQuestionsTypeDomain) {
		return questionAndQuestionTypeDao.insert(questionsAndQuestionsTypeDomain)!=null;
	}

	
	@Override
	public boolean deleteOrUpdate(QuestionsAndQuestionsTypeDomain questionsAndQuestionsTypeDomain) {
		return questionAndQuestionTypeDao.deleteOrUpdate(questionsAndQuestionsTypeDomain)!=null;
	}
	

}

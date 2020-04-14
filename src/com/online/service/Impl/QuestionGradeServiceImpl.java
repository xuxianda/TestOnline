package com.online.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.QuestionsGradeDao;
import com.online.domain.QuestionsGradeDomain;
import com.online.service.QuestionsGradeService;
@Service
public class QuestionGradeServiceImpl implements QuestionsGradeService {
	@Autowired
	private QuestionsGradeDao questionsGradeDao;
	
	@Override
	public boolean insert(QuestionsGradeDomain questionsGradeDomain) {
		System.out.println(questionsGradeDomain);
		return questionsGradeDao.insert(questionsGradeDomain)!=null;
	}

	@Override
	public boolean deleteOrUpdate(QuestionsGradeDomain questionsGradeDomain) {
		return questionsGradeDao.deleteOrUpdate(questionsGradeDomain)!=null;
	}

}

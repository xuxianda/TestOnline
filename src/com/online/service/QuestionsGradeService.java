package com.online.service;

import com.online.domain.QuestionsGradeDomain;

public interface QuestionsGradeService {
	
	boolean insert(QuestionsGradeDomain questionsGradeDomain);
	boolean deleteOrUpdate(QuestionsGradeDomain questionsGradeDomain);
}

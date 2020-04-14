package com.online.service;

import com.online.domain.QuestionsAndQuestionsTypeDomain;

public interface QuestionAndQuestionTypeService {
	
	boolean insert(QuestionsAndQuestionsTypeDomain questionsAndQuestionsTypeDomain);
	boolean deleteOrUpdate(QuestionsAndQuestionsTypeDomain questionsAndQuestionsTypeDomain);

}

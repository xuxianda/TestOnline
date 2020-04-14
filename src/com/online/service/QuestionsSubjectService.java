package com.online.service;

import com.online.domain.QuestionsSubjectDomain;

public interface QuestionsSubjectService {
	
	boolean insert(QuestionsSubjectDomain questionsSubjectDomain);
	boolean deleteOrUpdate(QuestionsSubjectDomain questionsSubjectDomain);
}

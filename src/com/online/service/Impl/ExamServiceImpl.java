package com.online.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.online.dao.ExamDao;
import com.online.domain.QuestionDomain;
import com.online.domain.TestDomain;
import com.online.domain.TestQuestionDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserQuestAndUserTestDomain;
import com.online.domain.UserQuestionsDomain;
import com.online.domain.UserTestRecordDomain;
import com.online.service.ExamService;

/**
 * @author 考试业务层实现类
 *	欧泽昌
 */
@Service
public class ExamServiceImpl implements ExamService{
	@Autowired
	ExamDao examDao;
	@Override
	public List<TestQuestionDomain> gainQuestion(TestDomain testDomain) {
		
		return examDao.gainQuestion(testDomain);
	}
	@Override
	public List<TestDomain> queryTest() {
		
		return examDao.queryTest();
	}
	
	@Override
	public UserQuestionsDomain answerEntering(UserQuestionsDomain uqDomain) {
		return examDao.answerEntering(uqDomain);
	}
	@Override
	public UserTestRecordDomain addTestRecord(UserTestRecordDomain utrd) {
		
		return examDao.addTestRecord(utrd);
	}
	@Override
	public UserQuestAndUserTestDomain examNumAndquestNum(UserQuestAndUserTestDomain userQuestAndUserTestDomain) {
		
		return examDao.examNumAndquestNum(userQuestAndUserTestDomain);
	}
	
	
	
	
}

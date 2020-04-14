package com.online.dao.Impl;


import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.online.dao.ExamDao;
import com.online.domain.QuestionDomain;
import com.online.domain.TestDomain;
import com.online.domain.TestQuestionDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserQuestAndUserTestDomain;
import com.online.domain.UserQuestionsDomain;
import com.online.domain.UserTestRecordDomain;
@Repository
public class ExamDaoImpl implements ExamDao {
	@Autowired
	private NutDao nutDao;
	@Override
	public List<TestQuestionDomain> gainQuestion(TestDomain testDomain) {
		
		return nutDao.query(TestQuestionDomain.class, Cnd.where("tid","=",testDomain.getTid()));
	}

	@Override
	public List<TestDomain> queryTest() {
		
		return nutDao.query(TestDomain.class,Cnd.where("qsname","=","启用"));
	}

	@Override
	public UserTestRecordDomain addUserTestRecord(UserTestRecordDomain utrd) {
		
		return null;
	}

	@Override
	public UserQuestionsDomain answerEntering(UserQuestionsDomain uqDomain) {
		
		return nutDao.insert(uqDomain);
	}

	@Override
	public UserTestRecordDomain addTestRecord(UserTestRecordDomain utrd) {
		// TODO Auto-generated method stub
		return nutDao.insert(utrd);
	}

	@Override
	public UserQuestAndUserTestDomain examNumAndquestNum(UserQuestAndUserTestDomain userQuestAndUserTestDomain) {
		// TODO Auto-generated method stub
		return nutDao.insert(userQuestAndUserTestDomain);
	}}

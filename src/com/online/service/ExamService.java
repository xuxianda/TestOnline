package com.online.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.online.domain.QuestionDomain;
import com.online.domain.TestDomain;
import com.online.domain.TestQuestionDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserQuestAndUserTestDomain;
import com.online.domain.UserQuestionsDomain;
import com.online.domain.UserTestRecordDomain;

/**
 * @author 欧泽昌
 *	考试业务层
 */


public interface ExamService {
	/**
	 * 	@author 获取试卷中的所有题目
	 *	@return 题目集合
	 */
	public List<TestQuestionDomain> gainQuestion(TestDomain testDomain);
	/**
	 * 	@author 获取所有试卷
	 *	@return 试卷集合
	 */
	public List<TestDomain> queryTest();
	
	/**
	 * @author 添加用户考试答题记录
	 *	@return UserQuestionsDomain对象 返回用户答题考试编号
	 */
	public UserQuestionsDomain answerEntering(UserQuestionsDomain uqDomain);
	/**
	 * @author 添加考试记录
	 *	@return UserTestRecordDomain对象 返回用户考试编号
	 */
	public UserTestRecordDomain addTestRecord(UserTestRecordDomain utrd); 
	
	/**
	 * @author 添加 考试与题目中间表
	 * 
	 *	@return 返回一个 UserQuestAndUserTestDomain 用于测试
	 *
	 */
	public UserQuestAndUserTestDomain examNumAndquestNum(UserQuestAndUserTestDomain userQuestAndUserTestDomain);
}

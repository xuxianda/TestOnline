package com.online.dao;

import java.util.List;

import com.online.domain.QuestionDomain;
import com.online.domain.TestDomain;
import com.online.domain.TestQuestionDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserQuestAndUserTestDomain;
import com.online.domain.UserQuestionsDomain;
import com.online.domain.UserTestRecordDomain;

/**
 * @author 欧泽昌
 *	学员考试持久层
 */


public interface ExamDao {
	/**
	 * 
	 * 获取考试试卷中的题目
	 *@return 题目集合
	 */
	public List<TestQuestionDomain> gainQuestion(TestDomain testDomain);
	
	/**
	 * 
	 *	获取所有试卷
	 *	@return 试卷集合
	 */
	public List<TestDomain> queryTest();
	
	/**
	 * @author 添加考试记录
	 *	@return 返回一个UserTestRecordDomain 记录考试编号
	 */
	public UserTestRecordDomain addUserTestRecord(UserTestRecordDomain utrd);
	
	/**
	 * @author 添加 考试作答完毕后的答案
	 * 
	 *	@return 返回一个 UserQuestionsDomain 记录答题编号
	 *
	 */
	public UserQuestionsDomain answerEntering(UserQuestionsDomain uqDomain);
	
	/**
	 * @author 添加 考试作答完毕后的用户考试记录
	 * 
	 *	@return 返回一个 UserQuestionsDomain 记录考试编号
	 *
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

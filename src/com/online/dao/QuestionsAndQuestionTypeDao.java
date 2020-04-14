package com.online.dao;

import com.online.domain.QuestionsAndQuestionsTypeDomain;

/**
 * 题目和类型的关系Dao层
 * 
 * @author lxh
 *
 */
public interface QuestionsAndQuestionTypeDao {
	/**
	 * 把题目和类型相关联插入到数据库中
	 * 
	 * @param questionsAndQuestionsTypeDomain
	 *            题目和类型关系对象
	 * @return QuestionsAndQuestionsTypeDomain 是否该对象为空
	 */
	QuestionsAndQuestionsTypeDomain insert(QuestionsAndQuestionsTypeDomain questionsAndQuestionsTypeDomain);
	/**
	 * 先根据题目编号删除一条关系记录，然后在重新添加题目和类型关系的数据
	 * @param questionsAndQuestionsTypeDomain 题目和类型关系对象
	 * @return  QuestionsAndQuestionsTypeDomain 是否该对象为空
	 */
	QuestionsAndQuestionsTypeDomain deleteOrUpdate(QuestionsAndQuestionsTypeDomain questionsAndQuestionsTypeDomain);
}

package com.online.dao;

import com.online.domain.QuestionsGradeDomain;

/**
 * 题目和等级关系dao层
 * 
 * @author lxh
 *
 */
public interface QuestionsGradeDao {
	/**
	 * 把题目和等级相关联插入到题目和等级关系表中
	 * 
	 * @param questionsGradeDomain
	 *            题目和等级关系对象
	 * @return QuestionsGradeDomain
	 */
	QuestionsGradeDomain insert(QuestionsGradeDomain questionsGradeDomain);
	/**
	 * 先根据题目编号删除一条关系记录，然后在重新添加题目的等级关系的数据
	 * @param questionsGradeDomain 题目和等级关系对象
	 * @return QuestionsGradeDomain
	 */
	QuestionsGradeDomain deleteOrUpdate(QuestionsGradeDomain questionsGradeDomain);
}

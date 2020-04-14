package com.online.dao;

import com.online.domain.QuestionsSubjectDomain;

/**
 * 题目和科目关系
 * @author lxh
 *
 */
public interface QuestionsSubjectDao {
	
	/**
	 * 把题目和科目相关联起来插入到题目和科目关系表中
	 * @param questionsSubjectDomain题目和科目关系对象
	 * @return QuestionsSubjectDomain
	 */
	QuestionsSubjectDomain insert(QuestionsSubjectDomain questionsSubjectDomain);
	/**
	 * 先根据题目编号删除一条关系记录，然后在重新添加题目的科目关系的数据
	 * @param questionsSubjectDomain 题目和科目关系对象
	 * @return QuestionsSubjectDomain
	 */
	QuestionsSubjectDomain deleteOrUpdate(QuestionsSubjectDomain questionsSubjectDomain);
}

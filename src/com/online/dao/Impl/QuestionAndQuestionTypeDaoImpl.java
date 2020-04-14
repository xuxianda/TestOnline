package com.online.dao.Impl;

import org.nutz.dao.Sqls;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.QuestionsAndQuestionTypeDao;
import com.online.domain.QuestionsAndQuestionsTypeDomain;

@Repository
public class QuestionAndQuestionTypeDaoImpl implements QuestionsAndQuestionTypeDao {
	@Autowired
	private NutDao nutDao;

	@Override
	public QuestionsAndQuestionsTypeDomain insert(QuestionsAndQuestionsTypeDomain questionsAndQuestionsTypeDomain) {
		return nutDao.insert(questionsAndQuestionsTypeDomain);
	}

	@Override
	public QuestionsAndQuestionsTypeDomain deleteOrUpdate(
			QuestionsAndQuestionsTypeDomain questionsAndQuestionsTypeDomain) {
		System.out.println(questionsAndQuestionsTypeDomain);
		Sql sql = Sqls.create("delete from questions_questionstype_db where qid="+questionsAndQuestionsTypeDomain.getQid());
		nutDao.execute(sql);
		return nutDao.insert(questionsAndQuestionsTypeDomain);
	}

}

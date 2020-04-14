package com.online.dao.Impl;

import org.nutz.dao.Sqls;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.QuestionsSubjectDao;
import com.online.domain.QuestionsSubjectDomain;
@Repository
public class QuestionSubjectDaoImpl implements QuestionsSubjectDao {
	@Autowired
	private NutDao nutDao;

	@Override
	public QuestionsSubjectDomain insert(QuestionsSubjectDomain questionsSubjectDomain) {
		return nutDao.insert(questionsSubjectDomain);
	}

	@Override
	public QuestionsSubjectDomain deleteOrUpdate(QuestionsSubjectDomain questionsSubjectDomain) {
		System.out.println(questionsSubjectDomain+"-------------");
		Sql sql = Sqls.create("delete from questions_subject_db where qid="+questionsSubjectDomain.getQid());
		nutDao.execute(sql);
		
		return nutDao.insert(questionsSubjectDomain);
	}

}

package com.online.dao.Impl;

import org.nutz.dao.Sqls;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.QuestionsGradeDao;
import com.online.domain.QuestionsGradeDomain;
@Repository
public class QuestionsGradeDaoImpl implements QuestionsGradeDao {
	@Autowired
	private NutDao nutDao;

	@Override
	public QuestionsGradeDomain insert(QuestionsGradeDomain questionsGradeDomain) {
		return nutDao.insert(questionsGradeDomain);
	}

	@Override
	public QuestionsGradeDomain deleteOrUpdate(QuestionsGradeDomain questionsGradeDomain) {
		System.out.println(questionsGradeDomain);
		Sql sql=Sqls.create("delete from questions_grade_db where qid="+questionsGradeDomain.getQid());
		nutDao.execute(sql);
		return nutDao.insert(questionsGradeDomain);
	}

}

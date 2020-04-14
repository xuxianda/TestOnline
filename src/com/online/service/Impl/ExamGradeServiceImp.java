package com.online.service.Impl;

import org.nutz.dao.Sqls;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.ExamGradeDao;
import com.online.domain.Page;
import com.online.domain.UserQuestionsDomain;
import com.online.domain.UserTestRecordDomain;
import com.online.service.ExamsGradeService;

@Service
public class ExamGradeServiceImp implements ExamsGradeService {
	@Autowired
	private ExamGradeDao dao;

	@Autowired
	private NutDao nutDao;

	@Override
	public boolean ExamAuto(int testid) {
		return dao.ExamAuto(testid);
	}

	@Override
	public UserTestRecordDomain testCheck(int testid) {
		return dao.testCheck(testid);
	}

	@Override
	public Page<UserTestRecordDomain> getTest(int page, int rows) {
		return dao.getTest(page, rows);
	}

	@Override
	public Page<UserTestRecordDomain> getTest(String tname, String uname, int page, int rows) {
		return dao.getTest(tname, uname, page, rows);
	}

	@Override
	public Page<UserQuestionsDomain> getStudentKey(int testid, int page, int rows) {
		return dao.getStudentKey(testid, page, rows);
	}

	@Override
	public Page<UserQuestionsDomain> getJ(int testid, int tyid, int page, int rows) {
		return dao.getJ(testid, tyid, page, rows);
	}

	@Override
	public boolean update(int testid, int score) {
		return dao.update(testid, score);
	}

}

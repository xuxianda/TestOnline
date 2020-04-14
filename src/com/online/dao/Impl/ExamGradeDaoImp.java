package com.online.dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.sql.SqlCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.ExamGradeDao;
import com.online.domain.Page;
import com.online.domain.UserDomain;
import com.online.domain.UserQuestionsDomain;
import com.online.domain.UserTestDomain;
import com.online.domain.UserTestRecordDomain;

/**
 * 试卷批阅dao层实现类
 * 
 * @author zjp
 *
 */
@Repository
public class ExamGradeDaoImp implements ExamGradeDao {

	@Autowired
	private NutDao nutDao;

	/**
	 * 自动批阅选择题
	 * 
	 * @param testid
	 *            考试编号
	 * @return
	 */
	@Override
	public boolean ExamAuto(int testid) {
		UserTestRecordDomain p = testCheck(testid);
		if (p != null) {
			Sql sql = Sqls.create("SELECT SUM(score) score FROM \r\n"
					+ " (SELECT uqid,uid,a.`qid`,qkey,testid FROM (SELECT a.uqid,uid,qid,qkey,testid FROM user_questions_db a JOIN userquest_usertest_db b WHERE testid=@testid AND a.uqid=b.uqid) a JOIN  questions_questionstype_db b WHERE a.qid = b.`qid` AND b.`tyid` IN (1,2))\r\n"
					+ " c JOIN (SELECT * FROM questions_db) d WHERE c.`qid` =d.qid AND c.qkey = d.qkey");
			sql.params().set("testid", testid);
			sql.setCallback(Sqls.callback.entities());
			sql.setEntity(nutDao.getEntity(UserTestRecordDomain.class));
			nutDao.execute(sql);
			List<UserTestRecordDomain> list = sql.getList(UserTestRecordDomain.class);
			int score = list.get(0).getScore();
			p.setScore(score);
			nutDao.update(p);
			return true;
		}

		return false;
	}

	@Override
	public UserTestRecordDomain testCheck(int testid) {
		UserTestRecordDomain p = nutDao.fetch(UserTestRecordDomain.class, Cnd.where("testid", "=", testid));
		return p;
	}

	/**
	 * 查询所有未批阅试卷
	 */
	@Override
	public Page<UserTestRecordDomain> getTest(int page, int rows) {
		Pager pager = nutDao.createPager(page, rows);
		Page<UserTestRecordDomain> pages = new Page<>();
		pages.setTotal(nutDao.query(UserTestRecordDomain.class, Cnd.where("0", "=", 0)).size());
		pages.setRows(nutDao.query(UserTestRecordDomain.class, Cnd.where("0", "=", 0), pager));
		return pages;
	}

	/**
	 * 模糊查询未批阅试卷
	 * 
	 * @param tname
	 *            试卷名称
	 * @param uname
	 *            用户名称
	 * @param page
	 * @param rows
	 * @return
	 */
	@Override
	public Page<UserTestRecordDomain> getTest(String tname, String uname, int page, int rows) {
		Pager pager = nutDao.createPager(page, rows);
		Page<UserTestRecordDomain> pages = new Page<>();
		pages.setTotal(nutDao.query(UserTestRecordDomain.class,
				Cnd.wrap("tname like '%" + tname + "%' and uname like '%" + uname + "%'")).size());
		pages.setRows(nutDao.query(UserTestRecordDomain.class,
				Cnd.wrap("tname like '%" + tname + "%' and uname like '%" + uname + "%'"), pager));
		return pages;
	}

	/**
	 * 根据考试Id获取答题卡等题目信息
	 * 
	 * @param testid
	 *            考试ID
	 * @param page
	 * @param rows
	 * @return
	 */
	@Override
	public Page<UserQuestionsDomain> getStudentKey(int testid, int page, int rows) {
		Pager pager = nutDao.createPager(page, rows);
		Page<UserQuestionsDomain> pages = new Page<>();
		pages.setTotal(nutDao.query(UserQuestionsDomain.class, Cnd.where("testid", "=", testid)).size());
		pages.setRows(nutDao.query(UserQuestionsDomain.class, Cnd.where("testid", "=", testid), pager));
		return pages;
	}

	/**
	 * 按题目类型获取答题卡题目
	 * 
	 * @param testid
	 * @param tyid
	 *            题目类型
	 * @param page
	 * @param rows
	 * @return
	 */
	@Override
	public Page<UserQuestionsDomain> getJ(int testid, int tyid, int page, int rows) {
		Pager pager = nutDao.createPager(page, rows);
		Page<UserQuestionsDomain> pages = new Page<>();
		pages.setTotal(nutDao.query(UserQuestionsDomain.class, Cnd.where("testid", "=", testid).and("tyid", "=", tyid))
				.size());
		pages.setRows(nutDao.query(UserQuestionsDomain.class, Cnd.where("testid", "=", testid).and("tyid", "=", tyid),
				pager));
		return pages;
	}

	@Override
	public boolean update(int testid, int score) {
		Sql sql = Sqls.create("update usertest_db set score = @score,state = 1 where testid = @testid");
		sql.setParam("score", score);
		sql.setParam("testid", testid);
		nutDao.execute(sql);
		return true;
	}

}

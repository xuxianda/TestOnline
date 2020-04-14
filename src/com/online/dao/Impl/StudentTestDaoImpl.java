package com.online.dao.Impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.QueryResult;
import org.nutz.dao.Sqls;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.StudentTestDao;
import com.online.domain.Page;
import com.online.domain.QuestionDomain;
import com.online.domain.TestDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserTestDomain;
@Repository
public class StudentTestDaoImpl implements StudentTestDao{

	@Autowired
	private NutDao nutDao;
	
	
	@Override
	public Page<UserTestDomain> paperStudent(int tid, int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		Page<UserTestDomain> p=new Page<>();
		p.setTotal(nutDao.query(UserTestDomain.class,Cnd.where("tid","=",tid).desc("score")).size());
		p.setRows( nutDao.query(UserTestDomain.class,Cnd.where("tid","=",tid).desc("score"), pager));
		int sumpage=p.getTotal()%pagesize==0?p.getTotal()/pagesize:p.getTotal()/pagesize+1;
		p.setSum(sumpage);
		return p;
	}

	@Override
	public Page<UserDomain> findIntegral(int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		Page<UserDomain> p=new Page<>();
		p.setTotal(nutDao.query(UserDomain.class,Cnd.orderBy().desc("integral")).size());
		p.setRows(nutDao.query(UserDomain.class,Cnd.orderBy().desc("integral"), pager));
		return p;
	}

	@Override
	public Page<UserDomain> firstIntegral(int page, int rows) {
		Pager pager = nutDao.createPager(page, rows);
		Page<UserDomain> p=new Page<>();
		p.setTotal(nutDao.query(UserDomain.class,Cnd.where("integral", "<", 1000).desc("integral")).size());
		p.setRows(nutDao.query(UserDomain.class,Cnd.where("integral", "<", 1000).desc("integral"), pager));
		return p;
	}

	@Override
	public Page<UserDomain> secondIntegral(int page, int rows) {
		Pager pager = nutDao.createPager(page, rows);
		Page<UserDomain> p=new Page<>();
		p.setTotal(nutDao.query(UserDomain.class,Cnd.where("integral", ">=", 1000).and("integral", "<", 3000).desc("integral")).size());
		p.setRows(nutDao.query(UserDomain.class,Cnd.where("integral", ">=", 1000).and("integral", "<", 3000).desc("integral"), pager));
		return p;
	}

	@Override
	public Page<UserDomain> lastIntegral(int page, int rows) {
		Pager pager = nutDao.createPager(page, rows);
		Page<UserDomain> p=new Page<>();
		p.setTotal(nutDao.query(UserDomain.class,Cnd.where("integral", ">=", 3000).desc("integral")).size());
		p.setRows(nutDao.query(UserDomain.class,Cnd.where("integral", ">=", 3000).desc("integral"), pager));
		return p;
	}

	@Override
	public Page<TestDomain> allTest(int page,int rows) {
		Page<TestDomain> p=new Page<>();
		Pager pager=nutDao.createPager(page, rows);
		p.setTotal(nutDao.query(TestDomain.class, null).size());
		p.setRows(nutDao.query(TestDomain.class, null,pager));
		return p;
	}

	@Override
	public Page<TestDomain> testName(String tname, int page, int rows) {
		Pager pager=nutDao.createPager(page, rows);
		Page<TestDomain> p=new Page<>();
		if(tname.length()>1) {
			p.setTotal(nutDao.query(TestDomain.class, Cnd.where("tname", "like", "%"+tname+"%")).size());
			p.setRows(nutDao.query(TestDomain.class, Cnd.where("tname", "like", "%"+tname+"%"),pager));
		}else {
			p.setTotal(nutDao.query(TestDomain.class, Cnd.where("tname", "like", tname)).size());
			p.setRows(nutDao.query(TestDomain.class, Cnd.where("tname", "like", tname),pager));
		}
		return p;
	}

	@Override
	public Page<UserTestDomain> getMyTest(int page,int rows,int uid) {
		Pager pager=nutDao.createPager(page, rows);
		Page<UserTestDomain> p=new Page<>();
		nutDao.query(UserTestDomain.class, Cnd.where("uid", "=", uid), pager);
		p.setTotal(nutDao.query(UserTestDomain.class, Cnd.where("uid", "=", uid)).size());
		p.setRows(nutDao.query(UserTestDomain.class, Cnd.where("uid", "=", uid), pager));
		int sumpage=p.getTotal()%rows==0?p.getTotal()/rows:p.getTotal()/rows+1;
		p.setSum(sumpage);
		return p;
	}

	@Override
	public Page<UserTestDomain> paperStudent2(int tid,int indexpage, int pagesize) {
		String sql="SELECT\r\n" + 
				"  `t`.`tid`      AS `tid`,\r\n" + 
				"  `t`.`tname`    AS `tname`,\r\n" + 
				"  `u`.`uname`    AS `uname`,\r\n" + 
				"  `tu`.`date`    AS `date`,\r\n" + 
				"  `tu`.`score`   AS `score`,\r\n" + 
				"  `u`.`username` AS `username`,\r\n" + 
				"  `u`.`uid`      AS `uid`,\r\n" + 
				"  `u`.`integral` AS `integral`,\r\n" + 
				"  `tu`.`testid`  AS `testid`,\r\n" + 
				"  `t`.`tsum`     AS `tsum`,\r\n" + 
				"  `t`.`time`     AS `time`,\r\n" +
				"  `u`.`gender` AS `gender`,\r\n" + 
				"  (SELECT COUNT(DISTINCT uu.score) FROM usertest_db uu WHERE uu.score>tu.score AND uu.tid="+tid+")+1 AS rank\r\n" + 
				"FROM `test_db` `t`\r\n" + 
				"    JOIN `user_db` `u`\r\n" + 
				"   JOIN `usertest_db` `tu`\r\n" + 
				"WHERE `t`.`tid` = `tu`.`tid`\r\n" + 
				"       AND `tu`.`uid` = `u`.`uid` AND t.tid="+tid+"\r\n" + 
				"       ORDER BY tu.score DESC    \r\n" + 
				"       ";
		Pager pager=nutDao.createPager(indexpage, pagesize);
		Sql sql2=Sqls.create(sql);
		sql2.setPager(pager);
		sql2.setCallback(Sqls.callback.records());
		sql2=nutDao.execute(sql2);
		List<UserTestDomain> list=sql2.getList(UserTestDomain.class);
		System.out.println(list);
		
		
		Sql sql3=Sqls.create(sql);
		sql3.setCallback(Sqls.callback.records());
		sql3=nutDao.execute(sql3);
		List<UserTestDomain> list2=sql3.getList(UserTestDomain.class);
		System.out.println(list2.size()+"----------------");
		Page<UserTestDomain> page=new Page<>();
		page.setRows(list);
		page.setTotal(list2.size());
		int sumpage=page.getTotal()%pagesize==0?page.getTotal()/pagesize:page.getTotal()/pagesize+1;
		page.setSum(sumpage);
		return page;
	}


	
}

package com.online.dao.Impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.QueryResult;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.TestDao;
import com.online.domain.Page;
import com.online.domain.QuestionDomain;
import com.online.domain.TestDomain;
@Repository
public class TestDaoImpl implements TestDao {
	@Autowired
	private NutDao nutDao;
	
	@Override
	public List<TestDomain> find(int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		List<TestDomain> list = nutDao.query(TestDomain.class,null,pager);
		pager.setRecordCount(nutDao.count(QuestionDomain.class));
		QueryResult queryResult = new QueryResult(list, pager);
		return queryResult.getList(TestDomain.class);
	}

	@Override
	public List<TestDomain> paperRank(String tname, int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		List<TestDomain> list = nutDao.query(TestDomain.class,Cnd.where("tname","like",tname), pager);
		pager.setRecordCount(nutDao.count(QuestionDomain.class));
		QueryResult queryResult = new QueryResult(list, pager);
		return queryResult.getList(TestDomain.class);
	}

	@Override
	public Page<TestDomain> findMy(int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		List<TestDomain> list = nutDao.query(TestDomain.class,Cnd.where("state", "=", 1),pager);
		Page<TestDomain> page=new Page<>();
		page.setTotal( nutDao.query(TestDomain.class,Cnd.where("state", "=", 1)).size());
		page.setRows(list);
		int sumpage=page.getTotal()%pagesize==0?page.getTotal()/pagesize:page.getTotal()/pagesize+1;
		page.setSum(sumpage);
		return page;
	}

}

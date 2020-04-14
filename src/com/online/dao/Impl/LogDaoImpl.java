package com.online.dao.Impl;

import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.LogDao;
import com.online.domain.LogDomain;
import com.online.domain.Page;
import com.online.domain.QuestionDomain;
@Repository
public class LogDaoImpl implements LogDao{
	@Autowired
	private NutDao nutDao;
	
	@Override
	public void add(LogDomain logDomain) {
		nutDao.insert(logDomain);
	}

	@Override
	public Page<LogDomain> allLog(int page,int rows) {
		Pager pager = nutDao.createPager(page, rows);
		Page<LogDomain> p=new Page<>();
		p.setTotal(nutDao.query(LogDomain.class,null).size());
		p.setRows(nutDao.query(LogDomain.class, null, pager));
		int sumpage=p.getTotal()%rows==0?p.getTotal()/rows:p.getTotal()/rows+1;
		p.setSum(sumpage);
		return p;
	}

}

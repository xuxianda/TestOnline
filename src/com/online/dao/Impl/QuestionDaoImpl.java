package com.online.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.QueryResult;
import org.nutz.dao.Sqls;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.dao.util.Daos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;
import com.online.dao.QuestionDao;
import com.online.domain.Page;
import com.online.domain.QuestionDomain;
import java.util.List;

@Repository
public class QuestionDaoImpl implements QuestionDao {
	@Autowired
	private NutDao nutDao;

	@Override
	public int add(int uid,QuestionDomain questionDomain) {
		Date date=new Date();
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String qdate=s.format(date);
		questionDomain.setQdate(qdate);
		QuestionDomain quest = nutDao.insert(questionDomain);
		Sql sql = Sqls.create("INSERT INTO uq_db(uid,qid) VALUES(@uid,@qid)");
		sql.setParam("uid", uid);
		sql.setParam("qid", quest.getQid());
		nutDao.execute(sql);
		return quest.getQid();
	}

	@Override
	public int stop(QuestionDomain questionDomain) {
		questionDomain.setQstate(-1);
		return nutDao.update(questionDomain);
	}

	@Override
	public int update(QuestionDomain questionDomain) {
		return nutDao.update(questionDomain);
	}

	@Override
	public Page<QuestionDomain> find(int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		Page<QuestionDomain> page=new Page<>();
		page.setTotal(nutDao.query(QuestionDomain.class,null).size());
		page.setRows(nutDao.query(QuestionDomain.class, null, pager));
		int sumpage=page.getTotal()%pagesize==0?page.getTotal()/pagesize:page.getTotal()/pagesize+1;
		page.setSum(sumpage);
		return page;
	}

	@Override
	public Page<QuestionDomain> find1(String qname, int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		Page<QuestionDomain> page=new Page<>();
		if(qname.length()>1) {
			page.setTotal(nutDao.query(QuestionDomain.class, Cnd.where("qname", "like", "%"+qname+"%"), pager).size());
			page.setRows(nutDao.query(QuestionDomain.class, Cnd.where("qname", "like", "%"+qname+"%"), pager));
		}else {
			page.setTotal(nutDao.query(QuestionDomain.class, Cnd.where("qname", "like", qname), pager).size());
			page.setRows(nutDao.query(QuestionDomain.class, Cnd.where("qname", "like", qname), pager));
		}
		return page;
	}

	@Override
	public Page<QuestionDomain> find2(String qname, int sid, int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		Page<QuestionDomain> page=new Page<>();
		page.setTotal(nutDao.query(QuestionDomain.class,
				Cnd.wrap("qname like '%" + qname + "%' and sid=" + sid + ""), pager).size());
		page.setRows(nutDao.query(QuestionDomain.class, Cnd.wrap("qname like '%" + qname + "%' and sid=" + sid + ""), pager));
		return page;
	}

	@Override
	public Page<QuestionDomain> find3(String qname, int sid, int gid, int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		Page<QuestionDomain> page=new Page<>();
		if(qname.length()>1) {
			page.setTotal(nutDao.query(QuestionDomain.class,Cnd.where("qname", "like","%"+qname+"%").and("sid", "=", sid).and("gid", "=", gid), pager).size());
			page.setRows(nutDao.query(QuestionDomain.class, Cnd.where("qname", "like","%"+qname+"%").and("sid", "=", sid).and("gid", "=", gid), pager));
		}else {
		page.setTotal(nutDao.query(QuestionDomain.class,Cnd.where("qname", "like", qname).and("sid", "=", sid).and("gid", "=", gid), pager).size());
		page.setRows(nutDao.query(QuestionDomain.class, Cnd.where("qname", "like", qname).and("sid", "=", sid).and("gid", "=", gid), pager));
		}
		return page;
	}

	@Override
	public Page<QuestionDomain> find4(int sid, int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		Page<QuestionDomain> page=new Page<>();
		page.setTotal(nutDao.query(QuestionDomain.class, Cnd.where("sid", "=", sid), pager).size());
		page.setRows(nutDao.query(QuestionDomain.class, Cnd.where("sid", "=", sid), pager));
		return page;
	}

	@Override
	public Page<QuestionDomain> find5(int sid, int gid, int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		Page<QuestionDomain> page=new Page<>();
		page.setTotal(nutDao.query(QuestionDomain.class, Cnd.wrap("sid=" + sid + " and gid=" + gid + ""),
				pager).size());
		page.setRows(nutDao.query(QuestionDomain.class, Cnd.wrap("sid=" + sid + " and gid=" + gid + ""), pager));
		return page;
	}

	@Override
	public Page<QuestionDomain> find6(int gid, int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		Page<QuestionDomain> page=new Page<>();
		page.setTotal(nutDao.query(QuestionDomain.class, Cnd.where("gid", "=", gid), pager).size());
		page.setRows(nutDao.query(QuestionDomain.class, Cnd.where("gid", "=", gid), pager));
		return page;
	}

	@Override
	public Page<QuestionDomain> find7(String qname, int gid, int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		Page<QuestionDomain> page=new Page<>();
		page.setTotal( nutDao.query(QuestionDomain.class,
				Cnd.wrap("qname like '%" + qname + "%' and gid=" + gid + ""), pager).size());
		page.setRows(nutDao.query(QuestionDomain.class, Cnd.wrap("qname like '%" + qname + "%' and gid=" + gid + ""), pager));
		return page;
	}

	@Override
	public List<QuestionDomain> MyQuestion(int uid, int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		List<QuestionDomain> list = nutDao.query(QuestionDomain.class,Cnd.where("uid","=",uid), pager);
		pager.setRecordCount(nutDao.count(QuestionDomain.class));
		QueryResult queryResult = new QueryResult(list, pager);
		return queryResult.getList(QuestionDomain.class);
	}

	@Override
	public List<QuestionDomain> getNo(int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		List<QuestionDomain> list = nutDao.query(QuestionDomain.class,Cnd.where("qstate","=",0), pager);
		pager.setRecordCount(nutDao.count(QuestionDomain.class));
		QueryResult queryResult = new QueryResult(list, pager);
		return queryResult.getList(QuestionDomain.class);
	}

	@Override
	public List<QuestionDomain> getYes(int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		List<QuestionDomain> list = nutDao.query(QuestionDomain.class,Cnd.where("qstate","=",1), pager);
		pager.setRecordCount(nutDao.count(QuestionDomain.class));
		QueryResult queryResult = new QueryResult(list, pager);
		return queryResult.getList(QuestionDomain.class);
	}

	@Override
	public List<QuestionDomain> getStop(int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		List<QuestionDomain> list = nutDao.query(QuestionDomain.class,Cnd.where("qstate","=",-1), pager);
		pager.setRecordCount(nutDao.count(QuestionDomain.class));
		QueryResult queryResult = new QueryResult(list, pager);
		return queryResult.getList(QuestionDomain.class);
	}

	@Override
	public int updateYesState(int qid) {
		Sql sql = Sqls.create("update questions_db set qstate=1 where qid=@qid");
		sql.setParam("qid", qid);
		Sql sql2=nutDao.execute(sql);
		System.out.println(sql2+"************");
		int is = sql.getUpdateCount();
		System.out.println(is+"-----------");
		return is;
	}

	@Override
	public int updateStopState(int qid) {
		Sql sql = Sqls.create("update questions_db set qstate=-1 where qid=@qid");
		sql.setParam("qid", qid);
		Sql sql2=nutDao.execute(sql);
		System.out.println(sql2+"************");
		int is = sql.getUpdateCount();
		System.out.println(is+"-----------");
		return is;
	}

	@Override
	public QuestionDomain getBeanQuestion(int qid) {
		List<QuestionDomain> list=nutDao.query(QuestionDomain.class,Cnd.where("qid","=",qid));
		return list.get(0);
	}

	
	

}

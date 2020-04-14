package com.online.dao.Impl;

import com.online.dao.IPaperDao;
import com.online.domain.GradeDomain;
import com.online.domain.QuestionDomain;
import com.online.domain.SubjectDomain;
import com.online.domain.TestDomain;
import com.online.domain.TestQuestionDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserTestDomain;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.dao.entity.*;

/*
* 管理员
* 试卷持久层实现类
* */
@Repository
public class IPaperDaoImpl implements IPaperDao {

	@Autowired
	private NutDao nd;

	@Override
	public List<TestDomain> paperFindAll() {
		
		return nd.query(TestDomain.class, null);
	}

	@Override
	public List<TestDomain> findTypeAll(String sname) {
		
		return nd.query(TestDomain.class, Cnd.where("sname","=",sname));
			
	}

	@Override
	public List<TestDomain> findNameAll(String tname) {

		return nd.query(TestDomain.class,Cnd.where("tname", "like", "%" + tname + "%"));
	}

	@Override
	public List<TestQuestionDomain> findQuestAll(int tid){
		
		return nd.query(TestQuestionDomain.class, Cnd.where("tid","=",tid));
		
	}
	
	
	
	
	@Override
	public TestDomain savePaper(TestDomain td,List<Integer> list,UserDomain user) {
		TestDomain test = nd.insert(td);
		
		
		
		Sql sql = Sqls.create("insert into $table(tid,uid) values (@tid,@uid)");
		sql.vars().set("table", "test_user_db");
		sql.params().set("tid", test.getTid());
		sql.params().set("uid", user.getUid());
		sql.params().set("uid", 1);
		
		nd.execute(sql);
		

		/*
		 * test_grade_db 试卷等级关系表 tid gid
		 * 根据前台选择的等级名称查询grade_db获取等级编号 gid
		 * */	
		
		
		Sql sql2 = Sqls.create("insert into $table(tid,gid) values(@tid,@gid)");
		sql2.vars().set("table", "test_grade_db");
		sql2.params().set("tid", test.getTid());
		sql2.params().set("gid",td.getGid());
		
		nd.execute(sql2);

		/*
		 * test_subject_db 试卷科目关系表 tid sid
		 * 根据前台选择的科目名称查询subject_db获取选择的科目编号 sid
		 * */ 
		
		Sql sql4 = Sqls.create("insert into $table(tid,sid) values(@tid,@sid)");
			sql4.vars().set("table", "test_subject_db");
			sql4.params().set("tid", test.getTid());
			sql4.params().set("sid", td.getSid());
		
		nd.execute(sql4);
			
			/*
			 * test_quest_db 试卷题目关系表
			 * 获取题目编号 question_db.qid
			 * 需循环录入
			 * 获取题目编号，循环录入 test_queset_db.qid
			 * 编号按数量重置，录入 test_queset_db.qorder
			 * */
			
		
		for (int i = 0; i < list.size(); i++) {
			Sql sql5 = Sqls.create("insert into $table(tid,qid,qorder) values(@tid,@qid,@qorder)");
			sql5.vars().set("table", "test_quest_db");
			sql5.params().set("tid", test.getTid());
			sql5.params().set("qid", list.get(i));
			sql5.params().set("qorder", i+1);
			 nd.execute(sql5);
		}
		
		return test;
		
	}

	@Override
	public int updatePaper(TestDomain td) {
		
			// 修改试卷表
			Sql sql = Sqls.create("update $table set tname=@tname,time=@time where tid=@tid");
				sql.vars().set("table", "test_db");
				sql.params().set("tname", td.getTname());
				sql.params().set("time", td.getTime());
				sql.params().set("tid", td.getTid());
				
			 nd.execute(sql);
			 
		return td.getTid();
	}
	
	@Override
	public int updateState(TestDomain td) {
		
		Sql sql = Sqls.create("update $table set state = 1 where tid=@tid");
			sql.vars().set("table", "test_db");
			sql.params().set("tid", td.getTid());
		nd.execute(sql);
		return td.getTid();
		
		
	}
	
	@Override
	public int updatePaperAdd(TestDomain td,List<Integer> list) {
		
		for (int i = 0; i < list.size(); i++) {
			
			Sql sql = Sqls.create("insert into $table(tid,qid) values(@tid,@qid)");
			sql.vars().set("table", "test_quest_db");
			sql.params().set("tid", td.getTid());
			sql.params().set("qid", list.get(i));
		nd.execute(sql);	
		}
		
		List<TestQuestionDomain> test = nd.query(TestQuestionDomain.class, Cnd.where("tid","=",td.getTid()));
		
		for (int i = 0; i < test.size(); i++) {
			Sql sql1 = Sqls.create("update $table set qorder=@qorder where tid=@tid and qid=@qid");
			sql1.vars().set("table", "test_quest_db");
			sql1.params().set("qorder", i+1);
			sql1.params().set("tid", test.get(i).getTid());
			sql1.params().set("qid", test.get(i).getQid());
		nd.execute(sql1);	
		}
		
		
		return td.getTid();
	}
	
	@Override
	public int updatePaperDel(TestDomain td,List<Integer> list) {
		
		for (int i = 0; i < list.size(); i++) {
			Sql sql = Sqls.create("delete from $table where tid=@tid and qid=@qid");
			sql.vars().set("table", "test_quest_db");
			sql.params().set("tid", td.getTid());
			sql.params().set("qid", list.get(i));
		nd.execute(sql);	
		}
		
		List<TestQuestionDomain> test = nd.query(TestQuestionDomain.class, Cnd.where("tid","=",td.getTid()));
		
		for (int i = 0; i < test.size(); i++) {
			Sql sql1 = Sqls.create("update $table set qorder=@qorder where tid=@tid and qid=@qid");
			sql1.vars().set("table", "test_quest_db");
			sql1.params().set("qorder", i+1);
			sql1.params().set("tid", test.get(i).getTid());
			sql1.params().set("qid", test.get(i).getQid());
		nd.execute(sql1);	
		}
		
		return td.getTid(); 
		
	}
	
	
	@Override
	public int updatePaperOpen(TestDomain td) {
		
		Sql sql = Sqls.create("update $table set state = 1 where tid=@tid");
			sql.vars().set("table", "test_all");
			sql.params().set("tid", td.getTid());
		
		nd.execute(sql);
		
		return td.getTid();
		
	}
	
	

	@Override
	public int deletePaper(int tid) {
		
		Sql sql = Sqls.create("update $table set state = -1 where tid=@tid");
			sql.vars().set("table", "test_all");
			sql.params().set("tid", tid);

		nd.execute(sql);
		return tid;
		
	}

	@Override
	public List<TestDomain> tasterFindAll() {

		return nd.query(TestDomain.class,Cnd.where("state","=",0));
	}
	
	
	@Override
    public List<QuestionDomain> lastFindTQT(int tid,int sid){
		
		Sql sql = Sqls.create("select * from questions t where t.qid in (select q.qid from questions_db q,questions_subject_db qs,subject_db s where q.qid=qs.qid and s.sid=qs.sid and s.sid=@sid and q.qstate=1 and q.qid not in (select q.qid from test_db t,test_quest_db tq,questions_db q where t.tid=@tid and t.tid=tq.tid and tq.qid=q.qid)) ");
			sql.params().set("tid", tid);
			sql.params().set("sid", sid);
		
		
		 sql.setCallback(Sqls.callback.entities());
		 Entity<QuestionDomain>entity = nd.getEntity(QuestionDomain.class);

		 sql.setEntity(entity);
		 nd.execute(sql);
			
		return sql.getList(QuestionDomain.class);
		
	}
	
	@Override
    public List<QuestionDomain> findQuestType(int gid,int sid){
		
		Sql sql = Sqls.create("select * from questions t where t.qid in (select q.qid from questions_db q,questions_subject_db qs,subject_db s,grade_db g,questions_grade_db qg where q.qid=qg.qid and qg.gid=g.gid and g.gid=@gid and q.qid=qs.qid and qs.sid=s.sid and s.sid=@sid and q.qstate = 1)");
			sql.params().set("gid", gid);
			sql.params().set("sid", sid);
			
		sql.setCallback(Sqls.callback.entities());
		Entity<QuestionDomain>entity = nd.getEntity(QuestionDomain.class);

		sql.setEntity(entity);
		nd.execute(sql);
		
		return sql.getList(QuestionDomain.class);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

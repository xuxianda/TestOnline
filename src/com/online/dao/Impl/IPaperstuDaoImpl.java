package com.online.dao.Impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Entity;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.IPaperstuDao;
import com.online.domain.QuestionDomain;
import com.online.domain.TestDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserTestDomain;
import com.online.service.IPaperstuService;

import jdk.nashorn.internal.objects.annotations.Where;

@Repository
public class IPaperstuDaoImpl implements IPaperstuDao{

	@Autowired
	private NutDao nd;
	
	
	@Override
	public List<TestDomain> stuTestQueryAll() {
		
		return nd.query(TestDomain.class, Cnd.where("state","=",1));
	}

	@Override
	public List<TestDomain> stuTypeQueryAll(String name) {
		
		return nd.query(TestDomain.class, Cnd.where("sname","=",name).and("state","=",1));
	}

	@Override
	public List<TestDomain> stuNameQueryAll(String name) {
		
		return nd.query(TestDomain.class, Cnd.where("tname", "like", "%" + name + "%").and("state","=",1));
	}
	
	
	@Override
	public List<UserDomain> queryUser() {
		
		
		Sql sql = Sqls.create("select * from $table");
			sql.vars().set("table", "user_db");
			sql.setCallback(Sqls.callback.entities());
			Entity<UserDomain>entity = nd.getEntity(UserDomain.class);

			sql.setEntity(entity);
			nd.execute(sql);
			
			return sql.getList(UserDomain.class);
		
	}
	
	@Override
	public List<UserTestDomain> queryTestToday(){
		
		return nd.query(UserTestDomain.class, null);
		
	}
	
	@Override
	public List<TestDomain> queryTestUser(UserDomain user){
		
		Sql sql = Sqls.create("select * from user_db u,test_user_db tu,test_db t,test_subject_db ts,subject_db s where u.uid=@uid and u.uid = tu.uid and tu.tid = t.tid and t.tid = ts.tid and ts.sid = s.sid");
			sql.params().set("uid", user.getUid());
			sql.setCallback(Sqls.callback.entities());
			Entity<TestDomain>entity = nd.getEntity(TestDomain.class);

			sql.setEntity(entity);
			nd.execute(sql);
			
			return sql.getList(TestDomain.class);
		
	}
	
	
	@Override
	public int updateUser(UserDomain user) {
		
		Sql sql = Sqls.create("update $table set username=@username , password=@password , uname=@uname , gender=@gender where uid=@uid");
			sql.vars().set("table", "user_db");
			sql.params().set("username", user.getUsername());
			sql.params().set("password", user.getPassword());
			sql.params().set("uname", user.getUname());
			sql.params().set("gender", user.getGender());
			sql.params().set("uid", user.getUid());
		nd.execute(sql);
		return user.getUid();
	}
	
	@Override
	public List<TestDomain> testNotQuery() {
		
		Sql sql = Sqls.create("SELECT \r\n" + 
				"	*\r\n" + 
				"FROM\r\n" + 
				"	test_db t,test_subject_db ts,subject_db s,test_user_db tu,user_db u\r\n" + 
				"WHERE\r\n" + 
				"	t.state = 0\r\n" + 
				"AND\r\n" + 
				"	t.tid = ts.tid\r\n" + 
				"AND	\r\n" + 
				"	ts.sid = s.sid\r\n" + 
				"AND\r\n" + 
				"	t.tid = tu.tid\r\n" + 
				"AND\r\n" + 
				"	tu.uid = u.uid");
			sql.setCallback(Sqls.callback.entities());
			Entity<TestDomain>entity = nd.getEntity(TestDomain.class);

			sql.setEntity(entity);
			nd.execute(sql);
		
		return sql.getList(TestDomain.class);
		
	}
	
	
	@Override
	public List<UserDomain> queryUserState(){
		
		Sql sql = Sqls.create("select * from $table where state = 0");
			sql.vars().set("table", "user_db");
			
			sql.setCallback(Sqls.callback.entities());
			Entity<UserDomain>entity = nd.getEntity(UserDomain.class);

			sql.setEntity(entity);
			nd.execute(sql);
		
		return sql.getList(UserDomain.class);
	}
	
	
	
	
	
	

}

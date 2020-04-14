package com.online.dao.Impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.dao.UserExamViewDao;
import com.online.domain.Page;
import com.online.domain.QuestionDomain;
import com.online.domain.UserExamViewDomain;

@Component
public class UserExamViewDaoImpl implements UserExamViewDao {
	@Autowired
	Dao dao = new NutDao();

	public UserExamViewDaoImpl() {
	}

	@Override
	public Page<UserExamViewDomain> find(String type, String value,int page,int rows) {
		Pager pager = dao.createPager(page, rows);
		Page<UserExamViewDomain> p=new Page<>();
		if ("all".equals(type)) {
			p.setTotal(dao.query(UserExamViewDomain.class, null).size());
			p.setRows(dao.query(UserExamViewDomain.class, null,pager));
		} else {
			if (value.length() > 1) {
				p.setTotal(dao.query(UserExamViewDomain.class, Cnd.where("type", "like", "%" + value + "%")).size());
				p.setRows(dao.query(UserExamViewDomain.class, Cnd.where("type", "like", "%" + value + "%"),pager));
			} else {
				p.setTotal(dao.query(UserExamViewDomain.class, Cnd.where("type", "like", value)).size());
				p.setRows(dao.query(UserExamViewDomain.class, Cnd.where("type", "like", value),pager));
			}
		}
		return p;
	}

}

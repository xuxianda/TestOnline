package com.online.dao.Impl;

import java.util.List;

import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.GradeDao;
import com.online.domain.GradeDomain;
@Repository
public class GradeDaoImpl implements GradeDao {
	@Autowired
	private NutDao nutDao;
	
	@Override
	public List<GradeDomain> findAll() {
		return nutDao.query(GradeDomain.class, null);
	}

}

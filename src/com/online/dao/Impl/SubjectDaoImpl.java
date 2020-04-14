package com.online.dao.Impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.SubjectDao;
import com.online.domain.Page;
import com.online.domain.SubjectDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserTestRecordDomain;
import com.online.domain.User_RoleDomain;
@Repository
public class SubjectDaoImpl implements SubjectDao {
	
	@Autowired
	private NutDao nutDao;
	
	@Override
	public Page<SubjectDomain> findAll(int page, int rows) {
		Pager pager = nutDao.createPager(page, rows);
		Page<SubjectDomain> pages=new Page<>();
		pages.setTotal(nutDao.query(SubjectDomain.class,null).size());
		pages.setRows(nutDao.query(SubjectDomain.class,null, pager));
		return pages;
	}
	/**
	 * 添加
	 */
	@Override
	public boolean add(SubjectDomain domain) {
		if (findName(domain.getSname()) == null) {//名称不允许重复
			nutDao.insert(domain);// 插入数据
			return true;
		}
	return false;
	}
	/**
	 * id获取
	 */
	private SubjectDomain find(int id) {
		return nutDao.fetch(SubjectDomain.class, Cnd.where("sid", "=", id));
	}
	/**
	 * 校验name重复
	 * @param name
	 * @return
	 */
	private SubjectDomain findName(String name) {
		return nutDao.fetch(SubjectDomain.class, Cnd.where("sname", "=", name));
	}
	/**
	 * 修改
	 * @param domain
	 * @return
	 */
	public boolean update(SubjectDomain domain) {
		if(findName(domain.getSname())!=null) {//新名称重复false
			return false;
		}
		if (find(domain.getSid()) != null) {
			SubjectDomain p = nutDao.fetch(SubjectDomain.class,  Cnd.where("sid", "=", domain.getSid()));
			p.setSname(domain.getSname());
			nutDao.update(p);
			return true;
		}
		return false;
	}
	@Override
	public List<SubjectDomain> findAll2() {
		return nutDao.query(SubjectDomain.class, null);
	}
}

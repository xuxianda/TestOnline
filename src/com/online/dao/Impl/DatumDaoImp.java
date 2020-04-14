package com.online.dao.Impl;

import java.util.Date;
import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.QueryResult;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.DatumDao;
import com.online.domain.DatumDomain;
import com.online.domain.QuestionDomain;
import com.online.domain.UserDomain;
/**
 * 资料dao实现类
 * @author zjp
 *
 */
@Repository
public class DatumDaoImp implements DatumDao {
	
	@Autowired
	private NutDao nutDao;

	/**
	 * 资料新增
	 * @param datum
	 * @return
	 */
	@Override
	public boolean add(DatumDomain datum) {
		DatumDomain domain = nutDao.insert(datum);// 插入数据
		return domain!=null;
	}
	/**
	 * 资料停用
	 * @param datum
	 * @return
	 */
	@Override
	public boolean delete(DatumDomain datum) {
		System.out.println(datum.getId()+">>>>>>>>>>>>>>>>>>>>>>>>");
		DatumDomain p =find(datum.getId());
		if ( p != null) {
			p.setState(-1);
			nutDao.update(p);
			return true;
		}
		return false;
	}
	/**
	 * 根据Id获取资料
	 * @param datumId
	 * @return
	 */
	public DatumDomain find(int datumId) {
		return nutDao.fetch(DatumDomain.class, Cnd.where("id", "=", datumId));
	}
	/**
	 * 资料修改
	 * @param datum
	 * @return
	 */
	@Override
	public boolean update(DatumDomain datum) {
		DatumDomain p =find(datum.getId());
		if ( p != null) {
			p.setName(datum.getName());//标题
			p.setViews(p.getViews());//浏览次数
			p.setContent(datum.getContent());//内容
			p.setCla(datum.getCla());//类型
			p.setState(datum.getState());
			nutDao.update(p);
			return true;
		}
		return false;
	}
	/**
	 * 资料名模糊查询资料
	 * @param datum
	 * @return
	 */
	@Override
	public List<DatumDomain> find(String datumName, int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		List<DatumDomain> list = nutDao.query(DatumDomain.class,Cnd.wrap("name like '%" + datumName + "%' "), pager);
		pager.setRecordCount(nutDao.count(DatumDomain.class));
		QueryResult queryResult = new QueryResult(list, pager);
		return queryResult.getList(DatumDomain.class);
	}
	/**
	 * 资料类型查询资料
	 * @param datumClass 资料类型名称
	 * @param indexpage	页数
	 * @param pagesize 每页显示条数
	 * @return
	 */
	@Override
	public List<DatumDomain> findClass(String datumClass, int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		List<DatumDomain> list = nutDao.query(DatumDomain.class, Cnd.where("cla","=",datumClass), pager);
		pager.setRecordCount(nutDao.count(DatumDomain.class));
		QueryResult queryResult = new QueryResult(list, pager);
		return queryResult.getList(DatumDomain.class);
	}
	/**
	 * 查询所有资料
	 * @param indexpage	页数
	 * @param pagesize 每页显示条数
	 * @return
	 */
	@Override
	public List<DatumDomain> findAll(int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		List<DatumDomain> list = nutDao.query(DatumDomain.class, Cnd.where("state","=",1), pager);
		pager.setRecordCount(nutDao.count(DatumDomain.class));
		QueryResult queryResult = new QueryResult(list, pager);
		return queryResult.getList(DatumDomain.class);
	}
	/**
	 * 根据创建时间获取资料
	 * @param date
	 * @param indexpage
	 * @param pagesize
	 * @return
	 */
	@Override
	public List<DatumDomain> findDate(Date date, int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		List<DatumDomain> list = nutDao.query(DatumDomain.class, Cnd.where("date",">",date), pager);
		pager.setRecordCount(nutDao.count(DatumDomain.class));
		QueryResult queryResult = new QueryResult(list, pager);
		return queryResult.getList(DatumDomain.class);
	}
	/**
	 * 获取未审核资料
	 * @param indexpage
	 * @param pagesize
	 * @return
	 */
	@Override
	public List<DatumDomain> findNo(int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		List<DatumDomain> list = nutDao.query(DatumDomain.class, Cnd.where("state","=",0), pager);
		pager.setRecordCount(nutDao.count(DatumDomain.class));
		QueryResult queryResult = new QueryResult(list, pager);
		return queryResult.getList(DatumDomain.class);
	}
	
	/**
	 * 资料启用
	 */
	@Override
	public boolean startUsing(int id) {
		DatumDomain p = nutDao.fetch(DatumDomain.class, Cnd.where("id", "=", id));
		if(p!=null) {
			p.setState(1);
			nutDao.update(p);
			return true;
		}
		return false;
	}
	/**
	 * 浏览记录
	 * @param datum
	 * @return
	 */
	@Override
	public boolean cookies(DatumDomain datum) {
		DatumDomain p =find(datum.getId());
		System.out.println(p+">>>>>>>>>>>");
		if ( p != null) {
			p.setName(p.getName());//标题
			p.setViews(p.getViews()+1);//浏览次数
			p.setContent(p.getContent());//内容
			p.setCla(p.getCla());//类型
			p.setState(p.getState());
			nutDao.update(p);
			return true;
		}
		return false;
	}
}

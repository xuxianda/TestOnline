package com.online.service.Impl;

import java.util.Date;
import java.util.List;

import org.nutz.dao.Cnd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.DatumDao;
import com.online.domain.DatumDomain;
import com.online.service.DatumService;
/**
 * 资料业务层实现类
 * @author Administrator
 *
 */
@Service
public class DatumServiceImp implements DatumService {
	@Autowired
	DatumDao dao;
	/**
	 * 资料新增
	 * @param datum
	 * @return
	 */
	@Override
	public boolean add(DatumDomain datum) {
		return dao.add(datum);
	}
	/**
	 * 资料停用
	 * @param datum
	 * @return
	 */
	@Override
	public boolean delete(DatumDomain datum) {
		return dao.delete(datum);
	}
	/**
	 * 资料修改
	 * @param datum
	 * @return
	 */
	@Override
	public boolean update(DatumDomain datum) {
		return dao.update(datum);
	}
	/**
	 * 资料名查询资料
	 * @param datum
	 * @return
	 */
	@Override
	public List<DatumDomain> find(String datumName, int indexpage, int pagesize) {
		return dao.find(datumName, indexpage, pagesize);
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
		return dao.findClass(datumClass, indexpage, pagesize);
	}

	@Override
	public List<DatumDomain> findAll(int indexpage, int pagesize) {
		return dao.findAll(indexpage, pagesize);
	}
	@Override
	public List<DatumDomain> findDate(Date date, int indexpage, int pagesize) {
		return dao.findDate(date, indexpage, pagesize);
	}
	@Override
	public List<DatumDomain> findNo(int indexpage, int pagesize) {
		return dao.findNo(indexpage, pagesize);
	}
	@Override
	public boolean startUsing(int id) {
		return dao.startUsing(id);
	}
	
	/**
	 * 根据Id获取资料
	 * @param datumId
	 * @return
	 */
	public DatumDomain find(int datumId) {
		return dao.find(datumId);
	}
	@Override
	public boolean cookies(DatumDomain datum) {
		
		return dao.cookies(datum);
	}
}

package com.online.dao;

import java.util.Date;
import java.util.List;

import com.online.domain.DatumDomain;

/**
 * 资料dao接口
 * @author Administrator
 *
 */
public interface DatumDao {
	/**
	 * 资料新增，新增状态为待审核
	 * @param datum
	 * @return
	 */
	public boolean add(DatumDomain datum);
	/**
	 * 资料停用
	 * @param datum
	 * @return
	 */
	public boolean delete(DatumDomain datum);
	
	/**
	 * 资料修改
	 * @param datum
	 * @return
	 */
	public boolean update(DatumDomain datum);
	
	/**
	 * 资料名查询资料
	 * @param datum
	 * @return
	 */
	public List<DatumDomain> find(String datumName, int indexpage, int pagesize);
	
	/**
	 * 资料类型查询资料
	 * @param datumClass 资料类型名称
	 * @param indexpage	页数
	 * @param pagesize 每页显示条数
	 * @return
	 */
	public List<DatumDomain> findClass(String datumClass,int indexpage,int pagesize);
	/**
	 * 
	 * @param indexpage	页数
	 * @param pagesize 每页显示条数
	 * @return
	 */
	public List<DatumDomain> findAll(int indexpage,int pagesize);
	
	/**
	 * 根据创建时间获取资料
	 * @param date
	 * @param indexpage
	 * @param pagesize
	 * @return
	 */
	public List<DatumDomain> findDate(Date date,int indexpage,int pagesize);
	/**
	 * 获取未审核资料
	 * @param indexpage
	 * @param pagesize
	 * @return
	 */
	public List<DatumDomain> findNo(int indexpage,int pagesize);
	/**
	 * 启用资料
	 * @param id
	 * @return
	 */
	public boolean startUsing(int id);
	/**
	 * id获取
	 * @param datumId
	 * @return
	 */
	public DatumDomain find(int datumId);
	
	/**
	 * 浏览记录
	 * @param datumId
	 * @return
	 */
	boolean cookies(DatumDomain datum);
}

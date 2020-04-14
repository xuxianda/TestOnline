package com.online.dao.Impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.UserDao;
import com.online.domain.DatumDomain;
import com.online.domain.Page;
import com.online.domain.QuestionDomain;
import com.online.domain.RoleDomain;
import com.online.domain.UserDomain;
import com.online.domain.User_RoleDomain;

/**
 * 用户持久层实现类
 * 
 * @author 许显达
 *
 */
@Repository
public class UserDaoImpl implements UserDao {
	// private Dao dao = new NutDao(DataSource.getDataSource());

	@Autowired
	private NutDao nutDao;

	public UserDaoImpl() {

	}

	@Override
	public Page<UserDomain> find(int page,int rows) {
		Pager pager = nutDao.createPager(page, rows);
		Page<UserDomain> p=new Page<>();
		p.setTotal(nutDao.query(UserDomain.class,null).size());
		p.setRows(nutDao.query(UserDomain.class,null, pager));
		System.out.println();
		return p;
	}

	@Override
	public UserDomain find(String username) {
		return nutDao.fetch(UserDomain.class, Cnd.where("username", "=", username));
	}

	/**
	 * 校验角色是否存在
	 * 
	 * @param id
	 * @return
	 */
	private RoleDomain findRole(int id) {
		return nutDao.fetch(RoleDomain.class, id);
	}

	/**
	 * 用户添加
	 */
	@Override
	public boolean add(UserDomain userDomain, int typeId) {
		if (find(userDomain.getUsername()) == null) {
			if (findRole(typeId) != null) {
				UserDomain user = nutDao.insert(userDomain);// 插入数据
				User_RoleDomain roUser_RoleDomain = new User_RoleDomain(user.getUid(), typeId);
				nutDao.insert(roUser_RoleDomain);// 写入中间表
				return true;
			}
		}
		return false;
	}

	/**
	 * 用户停用
	 */
	@Override
	public boolean delete(UserDomain userDomain) {
		if (find(userDomain.getUsername()) != null) {
			UserDomain p = nutDao.fetch(UserDomain.class, Cnd.where("username", "=", userDomain.getUsername()));
			p.setState(-1);
			nutDao.update(p);
			return true;
		}
		return false;
	}

	@Override
	public boolean update(UserDomain userDomain) {
		System.out.println(find(userDomain.getUsername())+">>>>>>>>>>>>");
		if (find(userDomain.getUsername()) == null) {
//			List<UserDomain> p = nutDao.query(UserDomain.class,Cnd.where("uid", "=", userDomain.getUid()));
//			p.get(0).setPassword(userDomain.getPassword());
//			p.get(0).setUname(userDomain.getUname());
//			p.get(0).setGender(userDomain.getGender());
//			p.get(0).setIntegral(userDomain.getIntegral());
			System.out.println(userDomain);
			UserDomain user = nutDao.fetch(UserDomain.class,Cnd.where("uid", "=", userDomain.getUid()));
			System.out.println(user);
			user.setUid(userDomain.getUid());
			user.setUsername(userDomain.getUsername());
			user.setPassword(userDomain.getPassword());
			user.setUname(userDomain.getUname());
			user.setGender(userDomain.getGender());
			user.setRid(userDomain.getRid());
			nutDao.update(user);
			User_RoleDomain ur=new User_RoleDomain();
			ur.setUid(userDomain.getUid());
			ur.setRid(userDomain.getRid());
			nutDao.update(ur,Cnd.where("uid", "=", userDomain.getUid()));
//			User_RoleDomain ur=new User_RoleDomain();
//			ur.
//			ur.setRid(userDomain.getRid());
//			nutDao.update(ur);
//			nutDao.update(p.get(0));
			return true;
		}
		return false;
	}

	/**
	 * 用户登陆
	 */
	@Override
	public UserDomain login(UserDomain user) {
		UserDomain p = nutDao.fetch(UserDomain.class,Cnd.wrap("username = '"+ user.getUsername()+"' and password = '"+user.getPassword()+"' and state = '1'"));
		return p;
	}

	/**
	 * 未过审核用户查询
	 */
	@Override
	public Page<UserDomain> findNo(int indexpage, int pagesize) {
		Pager pager = nutDao.createPager(indexpage, pagesize);
		Page<UserDomain> page=new Page<>();
		page.setTotal(nutDao.query(UserDomain.class, Cnd.where("state", "=", 0)).size());
		page.setRows(nutDao.query(UserDomain.class, Cnd.where("state", "=", 0), pager));
		return page;
	}
	/**
	 * 用户审核
	 */
	@Override
	public boolean userCheck(String username) {
		if (find(username) != null) {
			UserDomain p = nutDao.fetch(UserDomain.class,  Cnd.where("username", "=",username));
			p.setState(1);
			nutDao.update(p);
			return true;
		}
		return false;
	}
}

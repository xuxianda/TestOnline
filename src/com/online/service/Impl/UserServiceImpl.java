package com.online.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.UserDao;
import com.online.dao.Impl.UserDaoImpl;
import com.online.domain.Page;
import com.online.domain.UserDomain;
import com.online.service.UserService;
/**
 * 用户业务层实现类
 * @author 许显达
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	public UserServiceImpl() {
	}

	@Override
	public UserDomain find(String username) {
		UserDomain userDomain = userDao.find(username);
		return userDomain;
	}

	@Override
	public Page<UserDomain> find(int page,int rows) {
		return userDao.find(page,rows);
	}
	/**
	 * 添加角色
	 * 
	 */
	@Override
	public boolean add(UserDomain userDomain,int type) {
		return userDao.add(userDomain, type);
	}
	/**
	 * 角色删除
	 */
	@Override
	public boolean delete(UserDomain userDomain) {
		return userDao.delete(userDomain);
		
	}
	/**
	 * 角色修改
	 */
	@Override
	public boolean update(UserDomain userDomain) {
		return userDao.update(userDomain);
	}

	@Override
	public UserDomain login(UserDomain user) {
		return userDao.login(user);
	}
	
	/**
	 * 查询未审核角色
	 */
	@Override
	public Page<UserDomain> findNo(int page, int row) {
		return userDao.findNo(page, row);
	}

	@Override
	public boolean userCheck(String username) {
		return userDao.userCheck(username);
	}

}

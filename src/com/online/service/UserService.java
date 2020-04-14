package com.online.service;

import java.util.List;

import com.online.domain.Page;
import com.online.domain.UserDomain;
/**
 * 用户业务层接口
 * @author 许显达
 *
 */
public interface UserService {
	/**
	 * 查询用户
	 * @param username 账号
	 * @return 用户属性类
	 */
	UserDomain find(String username);
	/**
	 * 查询所有用户
	 * @return 用户集合
	 */
	Page<UserDomain> find(int page,int rows);
	/**
	 * 用户添加
	 */
	boolean add(UserDomain userDomain,int type);
	/**
	 * 用户删除
	 */
	boolean delete(UserDomain userDomain);
	/**
	 * 用户修改
	 */
	boolean update(UserDomain userDomain);
	/**
	 * 用户登陆
	 * @param user
	 * @return
	 */
	UserDomain login(UserDomain user);
	
	/**
	 * 获取未审核用户
	 * @param row
	 * @param page
	 * @return
	 */
	Page<UserDomain> findNo(int page,int row);
	
	/**
	 * 用户审核
	 * @param username
	 * @return
	 */
	boolean userCheck(String username);
}

package com.online.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.domain.Page;
import com.online.domain.UserDomain;
import com.online.service.UserService;
import com.online.utils.MyLog;
import com.online.utils.MyLog;

/**
 * 用户控制器
 * 
 * @author 许显达
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	public UserController() {
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	@ResponseBody
	public UserDomain find(@PathVariable(value = "username") String username) {
		return userService.find(username);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Page<UserDomain> find(int page,int rows) {
		System.out.println("---");
		return userService.find(page,rows);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public boolean add(UserDomain user, int type) {
		return userService.add(user, type);
	}

	@MyLog(value = "停用了一个用户")
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public boolean delete(UserDomain user) {
		return userService.delete(user);
	}

	@MyLog(value = "修改了一个用户")
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public boolean update(UserDomain user) {
		System.out.println(user);
		return userService.update(user);
	}

	/**
	 * 登陆
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@MyLog(value = "登录")
	@RequestMapping("login")
	@ResponseBody
	public boolean login(UserDomain user, Model model, HttpSession session) {
		session.removeAttribute("role");
		session.removeAttribute("user");
		System.out.println("...." + "/" + user);
		UserDomain domain = userService.login(user);
		if (domain != null) {
			session.setAttribute("role", domain.getRname());
			session.setAttribute("user", domain);
			System.out.println(domain.getRname());
			return true;
		}
		return false;
	}

	@RequestMapping(value = "/no", method = RequestMethod.GET)
	@ResponseBody
	public Page<UserDomain> findNo(int page, int rows) {
		return userService.findNo(page, rows);
	}

	@RequestMapping(value = "/out", method = RequestMethod.POST)
	@ResponseBody
	public boolean outLogin(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("User");
		System.out.println("user:" + request.getSession().getAttribute("user"));
		return true;
	}

	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	@ResponseBody
	public UserDomain adminLogin(UserDomain userDomain) {
		UserDomain admin = userService.login(userDomain);
		System.out.println(admin);
		return admin;
	}

	@MyLog(value = "审核了一个用户")
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	public boolean userCheck(UserDomain userDomain) {
		return userService.userCheck(userDomain.getUsername());
	}
}

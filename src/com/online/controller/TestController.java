package com.online.controller;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.domain.Page;
import com.online.domain.QuestionDomain;
import com.online.domain.TestDomain;
import com.online.domain.UserDomain;
import com.online.service.QuestionService;
import com.online.service.TestService;
import com.online.service.Impl.QuestionServiceImpl;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;

	/**
	 * 查询所有试卷
	 * 
	 * @param page
	 *            页数
	 * @param rows
	 *            每页显示的条数
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<TestDomain> find(int page, int rows) {

		return testService.find(page, rows);
	}

	@RequestMapping(value = "/findMy", method = RequestMethod.GET)
	@ResponseBody
	public Page<TestDomain> findMy(int page, int rows) {
		return testService.findMy(page, rows);
	}

	/**
	 * 根据试卷名模糊查询
	 * 
	 * @param tname
	 *            试卷名
	 * @param page
	 *            页数
	 * @param rows
	 *            每页显示的条数
	 * @return
	 */
	@RequestMapping(value = "/paperRank", method = RequestMethod.GET)
	@ResponseBody
	public List<TestDomain> paperRank(String tname, int page, int rows) {
		return testService.paperRank(tname, page, rows);
	}

}

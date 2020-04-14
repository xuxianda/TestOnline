package com.online.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
import org.nutz.dao.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.domain.DatumDomain;
import com.online.domain.Page;
import com.online.domain.UserQuestionsDomain;
import com.online.domain.UserTestRecordDomain;
import com.online.service.ExamsGradeService;
import com.online.utils.MyLog;

/**
 * 试卷批阅
 * 
 * @author zjp
 *
 */
@Controller
@RequestMapping("/examGrade")
public class ExamGradeController {
	@Autowired
	private ExamsGradeService service;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public boolean examAuto(int testid) {
		return service.ExamAuto(testid);
	}

	/**
	 * 查询全部未批阅
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Page<UserTestRecordDomain> getTestNo(int page, int rows) {
		return service.getTest(page, rows);
	}

	/**
	 * 模糊查询
	 * 
	 * @param tname
	 *            试卷名称
	 * @param uname
	 *            用户名称
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/zu", method = RequestMethod.GET)
	@ResponseBody
	public Page<UserTestRecordDomain> getTest(String tname, String uname, int page, int rows) {
		return service.getTest(tname, uname, page, rows);
	}

	/**
	 * 根据考试Id获取答题卡等题目信息 (答题卡全部题目)
	 * 
	 * @param testid
	 *            考试ID
	 * @param page
	 *            不用就传入1 ---- 99999
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	@ResponseBody
	public Page<UserQuestionsDomain> getTestStudent(int testid, int page, int rows) {
		return service.getStudentKey(testid, page, rows);
	}

	/**
	 * 按题目类型获取答题卡题目
	 * 
	 * @param testid
	 *            考试ID
	 * @param tyid
	 *            题目类型
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/type", method = RequestMethod.GET)
	@ResponseBody
	public Page<UserQuestionsDomain> getTestType(int testid, int typeid, int page, int rows) {
		return service.getJ(testid, typeid, page, rows);
	}
	@MyLog(value="批阅了一张试卷")
	@RequestMapping(value = "/set", method = RequestMethod.POST)
	@ResponseBody
	public boolean setScore(int testid, int score) {
		System.out.println("testid" + testid + "/" + "score" + score);
		return service.update(testid, score);
	}

}

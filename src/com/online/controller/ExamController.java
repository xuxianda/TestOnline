package com.online.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;

import com.online.domain.QuestionDomain;
import com.online.domain.TestDomain;
import com.online.domain.TestQuestionDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserQuestAndUserTestDomain;
import com.online.domain.UserQuestionsDomain;
import com.online.domain.UserRecordDomain;
import com.online.domain.UserTestRecordDomain;
import com.online.service.ExamService;
import com.online.service.Impl.ExamServiceImpl;
import com.online.utils.TimeUtils;

/**
 * @author 欧泽昌
 *	考试控制器
 */

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/exam")
public class ExamController {

	@Autowired
	ExamService examService;
	@Autowired
	UserTestRecordDomain userTestRecordDomain;
	@Autowired
	UserQuestAndUserTestDomain userQuestAndUserTestDomain;
	@Autowired
	UserQuestionsDomain userQuestionsDomain;

	/**
	 * @author 欧泽昌
	 * 
	 *         获取试卷
	 * @return 所有试卷展示页面
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String exam() {
		/*
		 * JSONArray jsonArray = new JSONArray(); for(Name nameList : nameLists){
		 * JSONObject jo = new JSONObject(); jo.put("NameCode", nameList.getNameCode());
		 * jo.put("Name", nameList.getName()); jsonArray.add(jo); } return
		 * jsonArray.toString();
		 */
		String testJson = "";
		JSONArray jsonArray = new JSONArray();
		List<TestDomain> testList = examService.queryTest();
		for (TestDomain testDomain : testList) {
			List<TestQuestionDomain> tqlist = examService.gainQuestion(testDomain);

			if (tqlist.size() != 0) {
				System.out.println(testDomain);
				JSONObject jo = new JSONObject();
				jo.put("id", testDomain.getTid());
				jo.put("tid", testDomain.getTid());
				jo.put("text", testDomain.getTname());
				jo.put("state", testDomain.getState());
				jo.put("sum", testDomain.getTsum());
				jo.put("time", testDomain.getTime());
				jo.put("tdate", testDomain.getTdate());
				jo.put("uname", testDomain.getUname());
				jsonArray.add(jo);
			}
		}
		testJson = "[{\"id\":1,    \r\n" + "    \"text\":\"试卷列表\",\"children\":" + jsonArray + "}]";

		ModelAndView mav = new ModelAndView();// 显示试卷页面
		for (int i = 0; i < testList.size(); i++) {
			if (testList.get(i).getState() == -1) {
				testList.remove(i);
			}
		}
		if (testList.isEmpty()) {
			mav.addObject("msg", "当前无试卷,请等待老师出试卷");
		} else {
			mav.addObject("testList", testList);
		}
		return testJson;
	}

	/**
	 * @author 获取试卷中的题目
	 * @retrun 考试页面
	 */
	@RequestMapping(value = "/4", method = RequestMethod.POST)
	public String gainQuestion(TestDomain testDomain, HttpServletRequest request) {
		UserDomain user = (UserDomain) request.getSession().getAttribute("User");
		// 把当前考试试卷放入session中,考试结束后方便获取
		request.getSession().setAttribute("testDomain", testDomain);
		List<TestQuestionDomain> tqlist = examService.gainQuestion(testDomain);
		ModelAndView mav = new ModelAndView();
		mav.addObject("tqlist", tqlist);// 返回题目集合
		request.getSession().setAttribute("testquestionList", tqlist);
		return "usertest";
	}

	/**
	 * @author 录入学员答题卡内容
	 * @retrun 考试页面
	 */
	@RequestMapping(value = "/2", method = RequestMethod.POST)
	@ResponseBody
	public boolean answerEntering(@RequestBody String json, HttpServletRequest request) {
		UserDomain user = (UserDomain) request.getSession().getAttribute("user");

		// 获取题目集合
		List<TestQuestionDomain> tqList = (List<TestQuestionDomain>) request.getSession().getAttribute("tqlist");
		JSONArray jsonArray = JSONArray.parseArray(json);

		// 获取考试试卷对象
		TestDomain testDomain = (TestDomain) request.getSession().getAttribute("testDomain");

		userTestRecordDomain.setUid(user.getUid());
		userTestRecordDomain.setTid(testDomain.getTid());
		userTestRecordDomain.setScore(testDomain.getTsum());
		userTestRecordDomain.setDate(TimeUtils.getCurrentDateTime());
		UserTestRecordDomain utrd = examService.addTestRecord(userTestRecordDomain);

		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject job = jsonArray.getJSONObject(i);
			userQuestionsDomain.setUid(user.getUid());
			for (int j = 0; j < tqList.size(); j++) {
				System.out.println((int) job.get("order") + "----" + tqList.get(j).getQorder());
				if ((int) job.get("order") + 1 == tqList.get(j).getQorder()) {
					System.out.println(tqList.get(j).getQid());
					userQuestionsDomain.setQid(tqList.get(j).getQid());

				}
			}
			userQuestionsDomain.setQkey((String) job.get("value"));

			UserQuestionsDomain userqDomain = examService.answerEntering(userQuestionsDomain);

			userQuestAndUserTestDomain.setTestid(utrd.getTestid());
			userQuestAndUserTestDomain.setUqid(userqDomain.getUqid());
			System.out.println(userQuestAndUserTestDomain);
			examService.examNumAndquestNum(userQuestAndUserTestDomain);
		}
		// for (int i = 0; i < urList.size(); i++) {
		// userQuestionsDomain.setUid(user.getUid());
		// for (int j = 0; j < tqList.size(); j++) {
		// if(urList.get(i).getOrder()==tqList.get(i).getQorder()) {
		// userQuestionsDomain.setQid(tqList.get(i).getQid());
		// }
		// }
		// userQuestionsDomain.setQkey(urList.get(i).getValue());
		// UserQuestionsDomain
		// userqDomain=examService.answerEntering(userQuestionsDomain);
		// userQuestAndUserTestDomain.setTestid(utrd.getTestid());
		// userQuestAndUserTestDomain.setUqid(userqDomain.getUqid());
		// examService.examNumAndquestNum(userQuestAndUserTestDomain);
		// }
		return true;
	}

	@RequestMapping(value = "/3", method = RequestMethod.POST)
	@ResponseBody
	public List<TestQuestionDomain> gainQuestionHistory(TestDomain testDomain, HttpServletRequest request) {
		System.out.println(testDomain);
		List<TestQuestionDomain> tqlist = examService.gainQuestion(testDomain);
		request.removeAttribute("tqlist");
		request.getSession().setAttribute("tqlist", tqlist);
		System.out.println(tqlist);
		String tqjson = JSONObject.toJSONString(tqlist);
		request.removeAttribute("tqjson");
		request.getSession().setAttribute("tqjson", tqjson);
		request.removeAttribute("testDomain");
		request.getSession().setAttribute("testDomain", testDomain);
		return tqlist;
	}
}

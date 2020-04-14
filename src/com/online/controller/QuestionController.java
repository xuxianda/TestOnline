package com.online.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.online.domain.Page;
import com.online.domain.QuestionDomain;
import com.online.domain.QuestionTypeDomain;
import com.online.domain.QuestionsAndQuestionsTypeDomain;
import com.online.domain.QuestionsGradeDomain;
import com.online.domain.QuestionsSubjectDomain;
import com.online.domain.UserDomain;
import com.online.service.QuestionAndQuestionTypeService;
import com.online.service.QuestionService;
import com.online.service.QuestionsGradeService;
import com.online.service.QuestionsSubjectService;
import com.online.utils.MyLog;

@Controller
@RequestMapping("/requestion")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@Autowired
	private QuestionAndQuestionTypeService questionAndQuestionTypeService;
	@Autowired
	private QuestionsGradeService questionGradeService;
	@Autowired
	private QuestionsSubjectService questionSubjectService;

	/**
	 * 添加题目
	 * 
	 * @param questionDomain
	 *            题目对象
	 * @param questionsSubjectDomain
	 *            题目和科目关系对象
	 * @param questionsGradeDomain
	 *            题目和等级关系对象
	 * @param questionsAndQuestionsTypeDomain
	 *            题目和类型关系对象
	 * @return list集合
	 */
	@MyLog(value="增加了一道题目")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String add(QuestionDomain questionDomain, QuestionsSubjectDomain questionsSubjectDomain,
			QuestionsGradeDomain questionsGradeDomain,
			QuestionsAndQuestionsTypeDomain questionsAndQuestionsTypeDomain,HttpServletRequest request) {
		HttpSession session=request.getSession();
		UserDomain user=(UserDomain) session.getAttribute("user");
		questionDomain.setQstate(0);
		int qid = questionService.add(user.getUid(), questionDomain);
		questionsSubjectDomain.setQid(qid);
		questionsGradeDomain.setQid(qid);
		questionsAndQuestionsTypeDomain.setQid(qid);
		boolean is = questionAndQuestionTypeService.insert(questionsAndQuestionsTypeDomain);
		boolean is2 = questionGradeService.insert(questionsGradeDomain);
		boolean is3 = questionSubjectService.insert(questionsSubjectDomain);
		if (is && is2 && is3) {
			return "添加成功";
		} else {
			return "添加失败";
		}

	}

	/**
	 * 停用题目
	 * 
	 * @param questionDomain
	 *            题目对象
	 * @return
	 */
	@MyLog(value="停用了一道题目")
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public String stop(QuestionDomain questionDomain) {
		System.out.println(questionDomain);
		int is = questionService.stop(questionDomain);
		if (is > 0) {
			return "停用成功";
		} else {
			return "停用失败";
		}

	}

	/**
	 * 修改题目
	 * 
	 * @param questionDomain
	 *            题目对象
	 * @param questionsSubjectDomain
	 *            题目与科目的关系对象
	 * @param questionsGradeDomain
	 *            题目与等级的关系对象
	 * @param questionsAndQuestionsTypeDomain
	 *            题目与类型的关系对象
	 * @return list集合
	 */
	@MyLog(value="修改了一道题目")
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public String update(QuestionDomain questionDomain, QuestionsSubjectDomain questionsSubjectDomain,
			QuestionsGradeDomain questionsGradeDomain,
			QuestionsAndQuestionsTypeDomain questionsAndQuestionsTypeDomain) {
		if (questionDomain.getTyid() == 3) {
			questionDomain.setA("");
			questionDomain.setB("");
			questionDomain.setC("");
			questionDomain.setD("");
		}
		System.out.println(questionDomain + "-----");
		System.out.println(questionsSubjectDomain + "----");
		System.out.println(questionsGradeDomain + "--------");
		System.out.println(questionsAndQuestionsTypeDomain + "---------");
		int is = questionService.update(questionDomain);
		boolean is2 = questionSubjectService.deleteOrUpdate(questionsSubjectDomain);
		boolean is3 = questionGradeService.deleteOrUpdate(questionsGradeDomain);
		boolean is4 = questionAndQuestionTypeService.deleteOrUpdate(questionsAndQuestionsTypeDomain);
		if (is > 0 && is2 && is3 && is4) {
			return "修改成功";
		} else {
			return "修改失败";
		}
	}

	/**
	 * 查询所有题目
	 * 
	 * @param page
	 *            页数
	 * @param rows
	 *            每页显示的条数
	 * @return list集合
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Page<QuestionDomain> find(int page, int rows) {
		return questionService.find(page, rows);
	}

	/**
	 * 组合查询题目
	 * 
	 * @param qname
	 *            题目
	 * @param sid
	 *            科目id
	 * @param gid
	 *            等级id
	 * @param page
	 *            页数
	 * @param rows
	 *            每页显示的条数
	 * @return
	 */
	@RequestMapping(value = "/combination", method = RequestMethod.GET)
	@ResponseBody
	public Page<QuestionDomain> find(String qname, int sid, int gid, int page, int rows) {
		System.out.println(qname + "," + sid + "," + gid + ",");
		if (qname != "" && sid == 0 && gid == 0) {
			// 根据题目查询
			return questionService.find1(qname, page, rows);
		} else if (qname != "" && sid != 0 && gid == 0) {
			// 根据题目，科目查询
			return questionService.find2(qname, sid, page, rows);
		} else if (qname != "" && sid != 0 && gid != 0) {
			// 根据题目，科目，等级查询
			Page<QuestionDomain> page2 = questionService.find3(qname, sid, gid, page, rows);
			System.out.println(page2);
			return page2;
		} else if (qname == "" && sid != 0 && gid == 0) {
			// 根据科目查询
			return questionService.find4(sid, page, rows);
		} else if (qname == "" && sid != 0 && gid != 0) {
			// 根据科目，等级查询
			return questionService.find5(sid, gid, page, rows);
		} else if (qname == "" && sid == 0 && gid != 0) {
			// 根据等级查询
			return questionService.find6(gid, page, rows);
		} else if (qname != "" && sid == 0 && gid != 0) {
			// 根据题目，等级查询
			return questionService.find7(qname, gid, page, rows);
		} else {
			// 全为空
			return questionService.find(page, rows);
		}
	}

	/**
	 * 根据题目查询
	 * 
	 * @param qname
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/findQuestion", method = RequestMethod.GET)
	@ResponseBody
	public Page<QuestionDomain> findQuestion(String qname, int page, int rows) {
		if (qname == "") {
			return questionService.find(page, rows);
		} else {
			return questionService.find1(qname, page, rows);
		}
	}

	/**
	 * 查询老师的所有题目
	 * 
	 * @param uid
	 *            用户id
	 * @param page
	 *            页数
	 * @param rows
	 *            每页显示的条数
	 * @return list集合
	 */
	@RequestMapping(value = "/MyQuestions", method = RequestMethod.GET)
	@ResponseBody
	public List<QuestionDomain> MyQuestions(int uid, int page, int rows) {
		return questionService.MyQuestion(uid, page, rows);
	}

	/**
	 * 查询所有未审核的题目
	 * 
	 * @param page
	 *            页数
	 * @param rows
	 *            每页显示的条数
	 * @return list集合
	 */
	@RequestMapping(value = "/getNo", method = RequestMethod.GET)
	@ResponseBody
	public List<QuestionDomain> getNo(int page, int rows) {
		return questionService.getNo(page, rows);
	}

	/**
	 * 查询所有已审核的题目
	 * 
	 * @param page
	 *            页数
	 * @param rows
	 *            每页显示的条数
	 * @return list集合
	 */
	@RequestMapping(value = "/getYes", method = RequestMethod.GET)
	@ResponseBody
	public List<QuestionDomain> getYes(int page, int rows) {
		return questionService.getYes(page, rows);
	}

	/**
	 * 查询所有已禁用的题目
	 * 
	 * @param page
	 *            页数
	 * @param rows
	 *            每页显示的条数
	 * @return list集合
	 */
	@RequestMapping(value = "/getStop", method = RequestMethod.GET)
	@ResponseBody
	public List<QuestionDomain> getStop(int page, int rows) {
		return questionService.getStop(page, rows);
	}

	/**
	 * 更改审核状态为已审核，或是把禁用改为启用
	 * 
	 * @param questionDomain
	 *            题目对象
	 * @return String
	 */
	@MyLog(value="审核或启用了一道题目")
	@RequestMapping(value = "/updateYesState", method = RequestMethod.PUT)
	@ResponseBody
	public String updateYesState(int qid) {
		System.out.println(qid);
		boolean is = questionService.updateYesState(qid);
		if (is) {
			return "更改成功";
		} else {
			return "更改失败";
		}
	}

	/**
	 * 更改状态为禁用
	 * 
	 * @param questionDomain
	 *            题目对象
	 * @return String
	 */
	@MyLog(value="禁用了一道题目")
	@RequestMapping(value = "/updateStopState", method = RequestMethod.PUT)
	@ResponseBody
	public String updateStopState(int qid) {
		System.out.println(qid);
		boolean is = questionService.updateStopState(qid);
		if (is) {
			return "更改成功";
		} else {
			return "更改失败";
		}
	}
	
	@RequestMapping(value = "/getBeanQuestion", method = RequestMethod.GET)
	@ResponseBody
	public QuestionDomain getBeanQuestion(int qid) {
		return questionService.getBeanQuestion(qid);
	}

}

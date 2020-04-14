package com.online.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.domain.Page;
import com.online.domain.TestDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserTestDomain;
import com.online.service.StudentTestService;
@Controller
@RequestMapping("/studentTest")
public class StudentTestControll {
	@Autowired
	private StudentTestService studentTestService;

	/**
	 * 根据试卷id查询考过该试卷的学生
	 * @param tid 试卷id
	 * @param page 页数
	 * @param rows 每页显示的条数
	 * @return
	 */
	@RequestMapping(value="/findStudent",method=RequestMethod.GET)
	@ResponseBody
	public Page<UserTestDomain> findStudent(int tid,int page,int rows){
		System.out.println("--------------"+tid);
		return studentTestService.paperStudent(tid, page, rows);
	}
	
	/**
	 * 查询所有的积分排名,由高到低
	 *@param page
	 * @param rows
	 * @return list
	 */
	@RequestMapping(value="/findIntegral",method=RequestMethod.GET)
	@ResponseBody
	public Page<UserDomain> findIntegral(int page,int rows){
		return studentTestService.findIntegral(page, rows);
	}
	
	/**
	 * 查询0-999的积分排名
	 * @param page 页面
	 * @param rows 每页显示的条数
	 * @return list
	 */
	@RequestMapping(value="/firstIntegral",method=RequestMethod.GET)
	@ResponseBody
	public Page<UserDomain> firstIntegral(int page,int rows){
		return studentTestService.firstIntegral(page, rows);
	}
	
	/**
	 * 查询1000-2999的积分排名
	 * @param page 页面
	 * @param rows 每页显示的条数
	 * @return list
	 */
	@RequestMapping(value="/secondIntegral",method=RequestMethod.GET)
	@ResponseBody
	public Page<UserDomain> secondIntegral(int page,int rows){
		return studentTestService.secondIntegral(page, rows);
	}
	
	/**
	 * 查询3000+积分
	 * @param page 页面
	 * @param rows 每页显示的条数
	 * @return list
	 */
	@RequestMapping(value="/lastIntegral",method=RequestMethod.GET)
	@ResponseBody
	public Page<UserDomain> lastIntegral(int page,int rows){
		return studentTestService.lastIntegral(page, rows);
	}
	
	/**
	 * 查询所有试卷
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/allTest",method=RequestMethod.GET)
	@ResponseBody
	public Page<TestDomain> allTest(int page,int rows){
		return studentTestService.allTest(page, rows);
	}
	
	/**
	 * 根据试卷名查询试卷
	 * @param tname
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value="/testName",method=RequestMethod.GET)
	@ResponseBody
	public Page<TestDomain>  testName(String tname,int page,int rows){
		if(tname=="") {
			return studentTestService.allTest(page, rows);
		}else {
			return studentTestService.testName(tname, page, rows);
		}
	}
	
	@RequestMapping(value="/getMyTest",method=RequestMethod.GET)
	@ResponseBody
	public Page<UserTestDomain> getMyTest(int page,int rows,HttpServletRequest request){
		HttpSession session=request.getSession();
		UserDomain user=(UserDomain) session.getAttribute("user");
		return studentTestService.getMyTest(page, rows, user.getUid());
	}
	
	@RequestMapping(value="/findStudent2",method=RequestMethod.GET)
	@ResponseBody
	public Page<UserTestDomain> findStudent2(int tid,int page,int rows){
		return studentTestService.paperStudent2(tid, page, rows);
	}

}

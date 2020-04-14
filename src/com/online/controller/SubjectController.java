package com.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.domain.Page;
import com.online.domain.SubjectDomain;
import com.online.service.SubjectService;
import com.online.utils.MyLog;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	/**
	 * 查询所有科目
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Page<SubjectDomain> findAll(int page, int rows){
		return subjectService.findAll(page,rows);
	}
	
	
	/**
	 * 查询所有科目
	 * @return
	 */
	@RequestMapping(value="/findAll2",method=RequestMethod.GET)
	@ResponseBody
	public List<SubjectDomain> findAll2(){
		return subjectService.findAll2();
	}
	

	/**
	 * 新增
	 * @param domain
	 * @return
	 */
	@MyLog(value="科目新增")
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public boolean add(SubjectDomain domain){
		return subjectService.add(domain);
	}
	/**
	 * 修改
	 * @param domain
	 * @return
	 */
	@MyLog(value="科目修改")
	@RequestMapping(value="up",method=RequestMethod.POST)
	@ResponseBody
	public boolean update(SubjectDomain domain){
		System.out.println(domain);
		return subjectService.update(domain);
	}
}

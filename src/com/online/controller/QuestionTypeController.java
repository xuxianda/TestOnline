package com.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.domain.QuestionTypeDomain;
import com.online.service.QuestionTypeService;

@Controller
@RequestMapping("/questionType")
public class QuestionTypeController {
	
	@Autowired
	private QuestionTypeService questionTypeService;
	
	/**
	 * 查询所有题目类型
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<QuestionTypeDomain> findAll(){
		return questionTypeService.findAll();
	}

}

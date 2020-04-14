package com.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.domain.Page;
import com.online.domain.UserExamViewDomain;
import com.online.service.UserExamViewService;

@Controller
@RequestMapping("/view")
public class ViewController {

	@Autowired
	private UserExamViewService userExamViewService;

	public ViewController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/userexam", method = RequestMethod.GET)
	@ResponseBody
	private Page<UserExamViewDomain> userexam(String type, String value,int page,int rows) {
		return userExamViewService.find(type, value,page,rows);
	}
}

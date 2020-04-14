package com.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.dao.GradeDao;
import com.online.domain.GradeDomain;
import com.online.service.GradeService;

@Controller
@RequestMapping("/grade")
public class GradeController {
	
	@Autowired
	private GradeService gradeService;
	
	/**
	 * 查询所有等级
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<GradeDomain> findAll(){
		return gradeService.findAll();
	}
	
}

package com.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.domain.LogDomain;
import com.online.domain.Page;
import com.online.service.LogService;

@Controller
@RequestMapping("/log")
public class LogController {
	@Autowired
	private LogService logService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Page<LogDomain> allLog(int page,int rows){
		return logService.allLog(page, rows);
	}
	
}

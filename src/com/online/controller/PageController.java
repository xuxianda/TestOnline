package com.online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	public PageController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/admin.action")
	public String admin() {
		return "admin";
	}

	@RequestMapping("/login.action")
	public String login() {
		return "login";
	}

	@RequestMapping("/index.action")
	public String index() {
		return "index";
	}

	@RequestMapping("/register.action")
	public String register() {
		return "register";
	}

	@RequestMapping("/user.action")
	public String user() {
		System.out.println("user.action");
		return "userr";
	}

	@RequestMapping("/userInfo.action")
	public String userInfo() {
		return "userInfo";
	}

	@RequestMapping("/announcement.action")
	public String announcement() {
		return "announcement";
	}

	@RequestMapping("/indexContent.action")
	public String indexCountent() {
		return "indexContent";
	}

	@RequestMapping("/study.action")
	public String study() {
		return "study";
	}

	@RequestMapping("/testpaperList.action")
	public String testpaperList() {
		return "testpaperList";
	}

	@RequestMapping("/testOnline.action")
	public String testOnline() {
		return "testOnline";
	}

	@RequestMapping("/usertest.action")
	public String usertest() {
		return "usertest";
	}

	@RequestMapping("/studyArea.action")
	public String studyArea() {
		return "studyArea";
	}

	@RequestMapping("/itemBank.action")
	public String itemBank() {
		return "ItemBank";
	}

	@RequestMapping("/examinationRecord.action")
	public String examinationRecord() {
		return "examinationRecord";
	}

	@RequestMapping("/examinationRank.action")
	public String examinationRank() {
		return "examinationRank";
	}

	@RequestMapping("/login_admin.action")
	public String login_admin() {
		return "login_admin";
	}
}

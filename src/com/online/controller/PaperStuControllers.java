package com.online.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.online.domain.TestDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserTestDomain;
import com.online.service.IPaperstuService;
import com.online.utils.TimeUtils;

@Controller
@RequestMapping("/stu")
public class PaperStuControllers {
	

	@Autowired
	private IPaperstuService ipaper;
	
	
	@RequestMapping("/sss")
	@ResponseBody
	public String Stu() {
		
		System.out.println(123);
		
		return "admin";
	}
	
	@GetMapping
	@ResponseBody
	public List<TestDomain> stuTestQuery(){
		
		List<TestDomain> list = ipaper.stuTestQueryAll();
		
		return list;
	}
	
	
	/*
	 * 学员：
	 * id = 1·试卷名模糊查询
	 * id = 2·科目名查询试卷
	 * */
	@GetMapping("/testAll")
	@ResponseBody
	public List<TestDomain> stuQueryFind(int id,String name){
		List<TestDomain> list = null;
		
		if (id == 1) {
			list = ipaper.stuNameQueryAll(name);
			
		}else if (id == 2) {
			list = ipaper.stuTypeQueryAll(name);
		}
		
		return list;
	}
	
	
	
	
	/*
	 * 查询用户个人考试记录 
	 * */
	@GetMapping("/utest")
	@ResponseBody
	public List<TestDomain> queryTestUser(HttpServletRequest request){
		
		UserDomain user = (UserDomain) request.getSession().getAttribute("user");
		
		System.out.println(user.getUid());
		
		List<TestDomain> list = ipaper.queryTestUser(user);
		
		System.out.println(list);
		
		
		return list;
	}
	
	/*
	 * 修改用户个人信息 
	 * password 密码 
	 * uname 	姓名
	 * gender   性别
	 * */
	@PostMapping
	@ResponseBody
	public boolean updateUser(UserDomain user,String pwd,HttpServletRequest request) {
		int x = 0;
		
		UserDomain user1 = (UserDomain) request.getSession().getAttribute("user");
		
		System.out.println(user.getPassword());
		
		System.out.println(pwd);
		
		if (pwd.equals(user.getPassword())) {
			x = 0;
		}else if (pwd.equals(user1.getPassword())) {
			x = ipaper.updateUser(user);
		}
		if (x > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	/*
	 * 首页查询用户数量
	 * */
	@GetMapping("/queryUser")
	@ResponseBody
	public int queryUser(HttpServletRequest request) {
		List<UserDomain> list = ipaper.queryUser();
		
		int count = list.size();
		request.getSession().setAttribute("userlist", count);
		
		return count;
	}
	
	
	/*
	 * 首页今日考试人数
	 * */
	@GetMapping("/testUser")
	@ResponseBody
	public int queryTestToday() {
		
		List<UserTestDomain> list = ipaper.queryTestToday();
		
		String now = TimeUtils.getCurrentDateTime();
		String num = now.substring(now.indexOf("月")+1,now.indexOf("日"));
		
		int count = 0;
		for (UserTestDomain u : list) {
			String date=u.getDate();

			String day=date.substring(date.indexOf("月")+1,date.indexOf("日"));
			if (num.equals(day)) {
				count++;
			}
		}
		return count;
	}
	
	
	
	/*
	 * 查询所有未审核的试卷
	 * */
	@GetMapping("/testPaper")
	@ResponseBody
	public int testNotQuery(){
		
		List<TestDomain> list = ipaper.testNotQuery();
		
		return list.size();
		
	}
	
	
	/*
	 * 查询所有未审核的用户
	 * */
	@GetMapping("/ustate")
	@ResponseBody
	public int queryUserState() {
		
		List<UserDomain> list = ipaper.queryUserState();
		
		return list.size();
	}
	
	
	
	
	
	
	
	

}

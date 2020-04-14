package com.online.controller;

import com.online.domain.QuestionDomain;
import com.online.domain.TestDomain;
import com.online.domain.TestQuestionDomain;
import com.online.domain.UserDomain;
import com.online.service.IPaperService;
import com.online.utils.MyLog;
import com.online.utils.TimeUtils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

import org.apache.catalina.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 唐晗 试卷控制器
 */

@Controller
@RequestMapping("/paper")
public class PaperController {

	@Autowired
	private IPaperService ipaper;

	@RequestMapping("/xxx")
	public String Paper() {

		System.out.println("   paper ......");

		return "index";
	}

	/*
	 * 管理员基本查询
	 */
	@GetMapping("/all")
	@ResponseBody
	public List<TestDomain> paperFindAll() {

		List<TestDomain> list = ipaper.paperFindAll();

		return list;

	}
	
	
	/*
	 * 根据试卷编号查询题目
	 * */
	@GetMapping("/quest")
	@ResponseBody
	public List<TestQuestionDomain> findQuestAll(int tid){
		
		List<TestQuestionDomain> list = ipaper.findQuestAll(tid);
		return list;
		
	}
	
	
	/**
     * 对比试卷，按试卷科目查询试卷没有出现的题目
     */
	@GetMapping("/type")
	@ResponseBody
	public  List<QuestionDomain> lastFindTQT(int tid,int sid){
		
		List<QuestionDomain> list = ipaper.lastFindTQT(tid, sid);
		return list;
	}
	
	
	/**
     * 试卷录入题目，按科目、等级查询题目，题目状态必须为 1
     */
   
	@GetMapping("/type1")
	@ResponseBody
    List<QuestionDomain> findQuestType(int gid,int sid){
    	
    	List<QuestionDomain> list = ipaper.lastFindTQT(gid, sid);
		return list;
    	
    }

	/*
	 * 管理员查询需审阅的试卷
	 */
	@GetMapping("/review")
	@ResponseBody
	public List<TestDomain> reviewFindAll() {

		List<TestDomain> list = ipaper.tasterFindAll();

		return list;

	}

	/**
	 * @author 管理员试卷查询 
	 * 试卷名称模糊查询 index = 1 
	 * 按科目查询试卷 index = 2 
	 */

	@GetMapping
	@ResponseBody
	public List<TestDomain> paperNameFind(int index, String name) {

		System.out.println(index);
		System.out.println(name);
		
		List<TestDomain> list = null;

		if (index == 1) {
			list = ipaper.findNameAll(name);

		} else if (index == 2) {
			list = ipaper.findTypeAll(name);

		}
		return list;

	}

	// 试卷添加
	@MyLog(value="试卷增加")
	@PostMapping
	@ResponseBody
	public String addPaper(HttpServletRequest request,TestDomain td, String paper,String score) {

		UserDomain user = (UserDomain) request.getSession().getAttribute("user");
		
		String str = TimeUtils.getCurrentDateTime();
		
		System.out.println(paper);
		System.out.println(score);
		
		String[] a= paper.substring(1, paper.length()-1).split(",");
		String[] b = score.substring(1,score.length()-1).split(",");

		int count = 0;
		int x[] = new int[b.length];
		for (int i = 0; i < b.length; i++) {
			x[i] = Integer.parseInt(b[i]);
			count += x[i];
		}
		
		List<Integer> list = new ArrayList<Integer>();
		int y[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			y[i] = Integer.parseInt(a[i]);
			list.add(y[i]);
		}
		
		  td.setTname(td.getTname()); 
		  td.setState(0); 
		  td.setTsum(count);
		  td.setTime(td.getTime()); 
		  td.setTdate(str); 
		  ipaper.savePaper(td,list,user);
		 

		return "admin";
	}

	@MyLog(value="试卷修改")
	@PatchMapping
	@ResponseBody
	public boolean updatePaper(TestDomain td,int index,String paper) {

		System.out.println(td);
		System.out.println(index);
		System.out.println(paper);
		
		int x = 0;
		if (index == 1) {
			x = ipaper.updateState(td);			// 试卷审核
		}else if(index == 2) {
			x = ipaper.updatePaperOpen(td); 		// 试卷启用
		}else if(index == 3) {
			 String[] a= paper.substring(1, paper.length()-1).split(","); 
			  List<Integer> list = new ArrayList<Integer>();
			  int y[] = new int[a.length]; 
			   for (int i = 0;i < a.length; i++){ 
				   y[i] = Integer.parseInt(a[i]); 
				   list.add(y[i]);
			   } 
				x = ipaper.updatePaperAdd(td,list);	// 试卷添题
		}else if(index == 4) {
			
			  String[] a= paper.substring(1, paper.length()-1).split(","); 
			  List<Integer> list = new ArrayList<Integer>();
			  int y[] = new int[a.length]; 
			   for (int i = 0;i < a.length; i++){ 
				   y[i] = Integer.parseInt(a[i]); 
				   list.add(y[i]);
			   } 
			   x =ipaper.updatePaperDel(td, list);			// 试卷删题
			   													
		}else if(index == 5){
					
			x = ipaper.updatePaper(td);
			
			// 试卷属性修改
		}
		
		if (x > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	// 试卷停用
	@MyLog(value="试卷停用")
	@DeleteMapping
	@ResponseBody
	public boolean deletePaper(int tid) {

		int x = ipaper.deletePaper(tid);
		if (x > 0) {
			return true;
		}else {
			return false;
		}
	}

}

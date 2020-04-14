package com.online.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.nutz.mvc.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.dao.AnnouncementDao;
import com.online.domain.Announcement;
import com.online.domain.Page;
import com.online.domain.UserDomain;
import com.online.utils.MyLog;
/**
 * 公告控制类
 * @author chenmei
 *
 */
@Controller
@RequestMapping("/announcement")
public class AnnouncementController {
	
	@Autowired
	AnnouncementDao announcement;
	
	@MyLog(value="添加了一条公告")
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
    public Announcement add(Announcement anno,HttpSession session) {
		UserDomain ud=(UserDomain)session.getAttribute("user");
    	Announcement announ = announcement.addAnnouncement(ud.getUid(),anno);
    	return announ;
    }
	
	@MyLog(value="删除了一条公告")
	@RequestMapping(method=RequestMethod.DELETE)
	@ResponseBody
	public int del(int aid) {
		return announcement.delAnnouncementByAid(aid);
	}
	
	@MyLog(value="修改了一条公告")
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseBody
	public boolean update(Announcement anno) {
		return announcement.updateAnnouncement(anno)>0;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public Page<Announcement> findAll(int page,int row) {
		return announcement.findAllAnnoucement(page, row);
	}
	
	@RequestMapping(value="/singleObject",method=RequestMethod.GET)
	@ResponseBody
	public Announcement findSingleObject(int aid) {
		return announcement.findAnnouncementByAid(aid);
	}
	
	@RequestMapping(value="/isuid",method=RequestMethod.GET)
	@ResponseBody
	public boolean Isuid(int aid,int uid) {
		return announcement.findByAid(aid, uid);
	}
	
	
}

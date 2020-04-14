package com.online.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.domain.DatumDomain;
import com.online.domain.Page;
import com.online.domain.QuestionDomain;
import com.online.domain.UserDomain;
import com.online.service.DatumService;
import com.online.utils.MyLog;
import com.online.utils.TimeUtils;

@Controller
@RequestMapping("/Datum")
public class DatumController {
	@Autowired
	private DatumService service;

	/**
	 * 获取所有通过资料
	 * 
	 * @param indexpage 当前页数
	 * @param pagesize
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<DatumDomain> find(int page, int rows,HttpServletRequest request) {
		System.out.println(123+">>>>>>>>>>>>>>>SS");
		List<DatumDomain> list = service.findAll(page, rows);
		return list;
	}

	/**
	 * 名称模糊查询
	 * 
	 * @param name
	 * @param indexpage
	 * @param pagesize
	 * @return
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ResponseBody
	public List<DatumDomain> findName(@RequestParam("name") String name, int page, int rows) {
		return service.find(name, page, rows);
	}

	/**
	 * 联合查询
	 * 
	 * @param sid
	 * @param gid
	 * @return
	 * @return
	 */
	@RequestMapping(value = "/{sid}", method = RequestMethod.POST)
	@ResponseBody
	public List<DatumDomain> query(int sid, String gid) {
		List<DatumDomain> list = new ArrayList();
		if (sid == 0 && !gid.equals("")) {
			// 根据题目查询

			return service.find(gid, 1, 99);
		} else if (sid != 0 && !gid.equals("")) {
			// 根据题目，科目查询
			list.add(service.find(sid));
			return list;
		} else if (sid != 0 && gid.equals("")) {
			list.add(service.find(sid));
			return list;
		} else {
			// 全为空
			return list;
		}
	}
	
	/**
	 * 获取未审核资料 查询地址 /Datum/no
	 * 
	 * @param indexpage
	 * @param pagesize
	 * @return
	 * @return
	 */
	@RequestMapping(value = "/no", method = RequestMethod.GET)
	@ResponseBody
	public List<DatumDomain> findNo(int page, int rows) {
		return service.findNo(page, rows);
	}

	/**
	 * 根据类型查询 查询地址 /Datum/cla
	 * 
	 * @param cla
	 * @param indexpage
	 * @param pagesize
	 * @return
	 */
	@RequestMapping(value = "/cla", method = RequestMethod.GET)
	@ResponseBody
	public List<DatumDomain> findClass(@RequestParam("cla") String cla, int page, int rows) {
		return service.findClass(cla, page, rows);
	}

	/**
	 * 根据创建时间查询 访问地址 /Datum/date
	 * 
	 * @param date
	 * @param indexpage
	 * @param pagesize
	 * @return 大于date创建时间
	 */
	@RequestMapping(value = "/date", method = RequestMethod.GET)
	@ResponseBody
	public List<DatumDomain> findDate(@RequestParam("date") Date date, int page, int rows) {
		return service.findDate(date, page, rows);
	}

	/**
	 * id获取
	 * 
	 * @param id
	 * @param indexpage
	 * @param pagesize
	 * @return
	 */
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	@ResponseBody
	public DatumDomain findId(@RequestParam("id") int id, int page, int rows) {
		return service.find(id);
	}

	/**
	 * 新增资料
	 * 
	 * @param datum
	 * @return
	 */
	@MyLog(value="新增一个资料")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public boolean add(DatumDomain datum) {
		datum.setDate(TimeUtils.getCurrentDateTime());
		return service.add(datum);
	}

	/**
	 * 资料停用
	 * 
	 * @param datum
	 * @return
	 */
	@MyLog(value="停用了一个资料")
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public boolean delete(DatumDomain datum) {
		return service.delete(datum);
	}

	/**
	 * 资料启用
	 * 
	 * @param id 资料ID
	 * @return
	 */
	@MyLog(value="启用一个资料")
	@RequestMapping(value = "/start")
	@ResponseBody
	public boolean stratUsing(int id) {
		return service.startUsing(id);
	}

	/**
	 * 资料修改
	 * 
	 * @param datum
	 * @return
	 */
	@MyLog(value="修改了一个资料")
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public boolean update(DatumDomain datum) {
		System.out.println(datum+"--------------");
		return service.update(datum);
	}
	/**
	 * 浏览记录增加
	 * 
	 * @param datum
	 * @return
	 */
	@RequestMapping("/cookies")
	public String cookies(DatumDomain datum) {
		System.out.println(datum+"--------------");
		service.cookies(datum);
		return "studyText";
	}
}

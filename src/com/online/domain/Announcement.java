package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

/**
 * 公告实体类
 * @author chenmei
 *
 */

@Table("announcement_db")
public class Announcement {
	public Announcement() {
	}

	public Announcement(int aid, String aname, String adate, String aurl, String author,int state) {
		this.aid = aid;
		this.aname = aname;
		this.adate = adate;
		this.aurl = aurl;
		this.author = author;
		this.state=state;
	}
   
	/**
	 * 公告编号
	 */
	@Id
	private int aid;
	
	/**
	 * 公告标题
	 */
	@Column
	private String aname;
	
	/**
	 * 公告内容
	 */
	@Column
	private String avalue;
	
	/**
	 * 发布公告时间
	 */
	@Column
	private String adate;
	
	/**
	 * 公告具体路径
	 */
	@Column
	private String aurl;
	
	/**
	 * 公告作者
	 */
	@Column
	private String author;
	
	/**
	 * 公告 状态  （0 发布  1禁止（删除））
	 */
	@Column
	private int state;	
	
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAvalue() {
		return avalue;
	}

	public void setAvalue(String avalue) {
		this.avalue = avalue;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	public String getAurl() {
		return aurl;
	}

	public void setAurl(String aurl) {
		this.aurl = aurl;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Announcement [aid=" + aid + ", aname=" + aname + ", avalue=" + avalue + ", adate=" + adate + ", aurl="
				+ aurl + ", author=" + author + ", state=" + state + "]";
	}

	
	

}

package com.online.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("datum_db")
public class DatumDomain {
	/**
	 * 资料ID
	 */
	@Id
	private int id;
	@Column	
	/**
	 * 资料名称
	 */
	private String name;
	/**
	 * 资料内容
	 */
	@Column	
	private String content;
	/**
	 * 资料创建时间
	 */
	@Column	
	private String date;
	/**
	 * 资料类型
	 */
	@Column	
	private String cla;
	/**
	 * 浏览次数
	 */
	@Column	
	private int views;
	/**
	 * 状态
	 */
	@Column	
	private int state;
	
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCla() {
		return cla;
	}
	public void setCla(String cla) {
		this.cla = cla;
	}
	
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public DatumDomain() {
		super();
	}
	public DatumDomain(int id, String name, String content, String date, String cla, int views, int state) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.date = date;
		this.cla = cla;
		this.views = views;
		this.state = state;
	}
	
	
}

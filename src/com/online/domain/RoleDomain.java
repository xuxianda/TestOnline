package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("role_db")
public class RoleDomain {
	@Id
	private int rid;//角色编号
	@Column
	private String rname;//角色名称
	public RoleDomain(int rid, String rname) {
		super();
		this.rid = rid;
		this.rname = rname;
	}
	public RoleDomain() {
		super();
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
}

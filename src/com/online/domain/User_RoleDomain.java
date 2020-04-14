package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

@Table("user_role_db")
public class User_RoleDomain {
	@Column
	private int uid; //用户ID
	@Column	
	private int rid; //角色Id
	public User_RoleDomain(int uid, int rid) {
		super();
		this.uid = uid;
		this.rid = rid;
	}
	public User_RoleDomain() {
		super();
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
}

package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 等级类
 * @author lxh
 *
 */
@Table("grade_db")
public class GradeDomain {
	@Id
	private int gid;//等级编号
	@Column
	private String gname;//等级名称
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	@Override
	public String toString() {
		return "Grade [gid=" + gid + ", gname=" + gname + "]";
	}
}

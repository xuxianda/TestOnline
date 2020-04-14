package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 科目表
 * @author lxh
 *
 */
@Table("subject_db")
public class SubjectDomain {
	@Id
	private int sid;//科目编号
	@Column
	private String sname;//科目名称


	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Override
	public String toString() {
		return "SubjectDomain [sid=" + sid + ", sname=" + sname + "]";
	}
	
	

}

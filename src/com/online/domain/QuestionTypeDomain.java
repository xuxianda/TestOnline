package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

/**
 * 题目类型类
 * 
 * @author lxh
 *
 */
@Table("questionstype_db")
public class QuestionTypeDomain {
	@Id
	private int tyid;// 题目类型编号
	@Column
	private String tyname;// 题目类型名称

	public int getTyid() {
		return tyid;
	}

	public String getTyname() {
		return tyname;
	}

	public void setTyid(int tyid) {
		this.tyid = tyid;
	}

	public void setTyname(String tyname) {
		this.tyname = tyname;
	}

	public QuestionTypeDomain() {
		super();
	}

	public QuestionTypeDomain(int tyid, String tyname) {
		super();
		this.tyid = tyid;
		this.tyname = tyname;
	}

	@Override
	public String toString() {
		return "QuestionTypeDomain [tyid=" + tyid + ", tyname=" + tyname + "]";
	}

}

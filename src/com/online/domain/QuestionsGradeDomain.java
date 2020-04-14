package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;
/**
 * 题目和等级关系表
 * @author lxh
 *
 */
@Table("questions_grade_db")
public class QuestionsGradeDomain {
	@Column
	private int qid;//题目编号
	@Column
	private int gid;//等级编号
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	@Override
	public String toString() {
		return "QuestionsGradeDomain [qid=" + qid + ", gid=" + gid + "]";
	}
	
}

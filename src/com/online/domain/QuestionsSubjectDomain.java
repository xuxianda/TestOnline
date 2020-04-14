package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;
/**
 * 题目和科目关系类
 * @author lxh
 *
 */
@Table("questions_subject_db")
public class QuestionsSubjectDomain {
	@Column
	private int sid;//科目编号
	@Column
	private int qid;//题目编号
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	@Override
	public String toString() {
		return "QuestionsSubjectDomain [sid=" + sid + ", qid=" + qid + "]";
	}
	
}

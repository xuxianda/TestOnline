package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;
/**
 * 题目和类型的关系表
 * @author lxh
 *
 */
@Table("questions_questionstype_db")
public class QuestionsAndQuestionsTypeDomain {
	@Column
	private int qid;//题目编号
	@Column
	private int tyid;//类型编号
	
	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getTyid() {
		return tyid;
	}

	public void setTyid(int tyid) {
		this.tyid = tyid;
	}

	
}

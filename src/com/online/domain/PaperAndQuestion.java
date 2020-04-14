package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/*
 * 试卷和题目的关系表
 * */
@Table("test_quest_db")
public class PaperAndQuestion {
	
	@Column
	private int tid;	//试卷编号
	
	@Column 
	private int qid;	//题目编号
	
	
	@Column
	private int qorder; 	 // 题目顺序


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	public int getQid() {
		return qid;
	}


	public void setQid(int qid) {
		this.qid = qid;
	}


	public int getQorder() {
		return qorder;
	}


	public void setQorder(int qorder) {
		this.qorder = qorder;
	}


	@Override
	public String toString() {
		return "PaperAndQuestion [tid=" + tid + ", qid=" + qid + ", qorder=" + qorder + "]";
	}
	
	
	
	
	
	
	
}

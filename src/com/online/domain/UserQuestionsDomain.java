package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;
import org.springframework.stereotype.Component;
@Table("user_questions_db")
@View("studenttest")
@Component
public class UserQuestionsDomain {
	@Id
	private int uqid;
	@Column
	private int uid;
	@Column
	private int qid;
	@Column
	private String qkey;
	@Column
	@Readonly
	private int testid;//考试ID
	@Column
	@Readonly
	private String qname;//考试题目
	@Column
	@Readonly
	private int score;//题目分数
	@Column
	@Readonly
	private String a;
	@Column
	@Readonly
	private String b;
	@Column
	@Readonly
	private String c;
	@Column
	@Readonly
	private String d;
	@Column
	@Readonly
	private String userqkey;//用户作答
	@Column
	@Readonly
	private String tqkey;//正确答案
	@Column
	@Readonly
	private String tyname;//题目类型
	@Column
	@Readonly
	private int tyid;//题目类型ID
	public int getUqid() {
		return uqid;
	}
	public void setUqid(int uqid) {
		this.uqid = uqid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQkey() {
		return qkey;
	}
	public void setQkey(String qkey) {
		this.qkey = qkey;
	}
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public String getUserQkey() {
		return userqkey;
	}
	public void setUserQkey(String userqkey) {
		this.userqkey = userqkey;
	}
	public String getTqkey() {
		return tqkey;
	}
	public void setTqkey(String tqkey) {
		this.tqkey = tqkey;
	}
	public String getTyname() {
		return tyname;
	}
	public void setTyname(String tyname) {
		this.tyname = tyname;
	}
	public int getTyid() {
		return tyid;
	}
	public void setTyid(int tyid) {
		this.tyid = tyid;
	}
	@Override
	public String toString() {
		return "UserQuestionsDomain [uqid=" + uqid + ", uid=" + uid + ", qid=" + qid + ", qkey=" + qkey + ", testid="
				+ testid + ", qname=" + qname + ", score=" + score + ", a=" + a + ", b=" + b + ", c=" + c + ", d=" + d
				+ ", userqkey=" + userqkey + ", tqkey=" + tqkey + ", tyname=" + tyname + ", tyid=" + tyid + "]";
	}
	
	
	
}

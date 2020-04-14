package com.online.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

/**
 * 题目类
 * 
 * @author lxh
 *
 */
@Table("questions_db")
@View("questions")
public class QuestionDomain {
	@Id
	private int qid;// 题目编号
	@Column
	private String qname;// 题目内容
	@Column
	private int score;// 题目分值
	@Column
	private String a;
	@Column
	private String b;
	@Column
	private String c;
	@Column
	private String d;
	@Column
	private String qkey;
	@Column
	private int qstate;
	@Column
	private String qdate;

	@Column
	@Readonly
	private int gid;
	@Column
	@Readonly
	private String gname;
	@Column
	@Readonly
	private int tyid;
	@Column
	@Readonly
	private String tyname;
	@Column
	@Readonly
	private int sid;
	@Column
	@Readonly
	private String sname;

	@Column
	@Readonly
	private int uid;

	@Column
	@Readonly
	private String username;

	@Column
	@Readonly
	private String qsname;

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
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

	public String getQkey() {
		return qkey;
	}

	public void setQkey(String qkey) {
		this.qkey = qkey;
	}

	public int getQstate() {
		return qstate;
	}

	public void setQstate(int qstate) {
		this.qstate = qstate;
	}

	public String getQdate() {
		return qdate;
	}

	public void setQdate(String qdate) {
		this.qdate = qdate;
	}

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

	public int getTyid() {
		return tyid;
	}

	public void setTyid(int tyid) {
		this.tyid = tyid;
	}

	public String getTyname() {
		return tyname;
	}

	public void setTyname(String tyname) {
		this.tyname = tyname;
	}

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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getQsname() {
		return qsname;
	}

	public void setQsname(String qsname) {
		this.qsname = qsname;
	}

	public QuestionDomain() {

	}

	public QuestionDomain(int qid, String qname, int score, String a, String b, String c, String d, String qkey,
			int qstate, String qdate, int gid, String gname, int tyid, String tyname, int sid, String sname, int uid,
			String username, String qsname) {
		this.qid = qid;
		this.qname = qname;
		this.score = score;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.qkey = qkey;
		this.qstate = qstate;
		this.qdate = qdate;
		this.gid = gid;
		this.gname = gname;
		this.tyid = tyid;
		this.tyname = tyname;
		this.sid = sid;
		this.sname = sname;
		this.uid = uid;
		this.username = username;
		this.qsname = qsname;
	}

	@Override
	public String toString() {
		return "QuestionDomain [qid=" + qid + ", qname=" + qname + ", score=" + score + ", a=" + a + ", b=" + b + ", c="
				+ c + ", d=" + d + ", qkey=" + qkey + ", qstate=" + qstate + ", qdate=" + qdate + ", gid=" + gid
				+ ", gname=" + gname + ", tyid=" + tyid + ", tyname=" + tyname + ", sid=" + sid + ", sname=" + sname
				+ ", uid=" + uid + ", username=" + username + ", qsname=" + qsname + "]";
	}

}

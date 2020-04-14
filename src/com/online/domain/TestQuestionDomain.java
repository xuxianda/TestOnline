package com.online.domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

@Table("test_quest_db")
@View("test_questions")
public class TestQuestionDomain {
	@Column
	private int tid;
	@Column
	private int qid;
	@Column
	private int qorder;

	@Column
	@Readonly
	private String tname;
	@Column
	@Readonly
	private int tsum;
	@Column
	@Readonly
	private int time;
	@Column
	@Readonly
	private Date tdate;
	@Column
	@Readonly
	private String qname;
	@Column
	@Readonly
	private int score;
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
	private String qkey;
	@Column
	@Readonly
	private int qstate;
	@Column
	@Readonly
	private Timestamp qdate;

	@Column
	@Readonly
	private String tyname;
	
	@Column
	@Readonly
	private String sname;
	
	@Column
	@Readonly
	private String gname;
	
	

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getTyname() {
		return tyname;
	}

	public void setTyname(String tyname) {
		this.tyname = tyname;
	}

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

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public int getTsum() {
		return tsum;
	}

	public void setTsum(int tsum) {
		this.tsum = tsum;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
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

	public Timestamp getQdate() {
		return qdate;
	}

	public void setQdate(Timestamp qdate) {
		this.qdate = qdate;
	}
	
	public TestQuestionDomain() {
	}

	
	
	public TestQuestionDomain(int tid, int qid, int qorder, String tname, int tsum, int time, Date tdate, String qname,
			int score, String a, String b, String c, String d, String qkey, int qstate, Timestamp qdate, String tyname,
			String sname, String gname) {
		super();
		this.tid = tid;
		this.qid = qid;
		this.qorder = qorder;
		this.tname = tname;
		this.tsum = tsum;
		this.time = time;
		this.tdate = tdate;
		this.qname = qname;
		this.score = score;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.qkey = qkey;
		this.qstate = qstate;
		this.qdate = qdate;
		this.tyname = tyname;
		this.sname = sname;
		this.gname = gname;
	}

	@Override
	public String toString() {
		return "TestQuestionDomain [tid=" + tid + ", qid=" + qid + ", qorder=" + qorder + ", tname=" + tname + ", tsum="
				+ tsum + ", time=" + time + ", tdate=" + tdate + ", qname=" + qname + ", score=" + score + ", a=" + a
				+ ", b=" + b + ", c=" + c + ", d=" + d + ", qkey=" + qkey + ", qstate=" + qstate + ", qdate=" + qdate
				+ ", tyname=" + tyname + ", sname=" + sname + ", gname=" + gname + "]";
	}

	
	
	
	
}

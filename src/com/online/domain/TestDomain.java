package com.online.domain;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

/**
 * @author 试卷实体类
 *
 */
@Table("test_db")
@View("test_all")
public class TestDomain {
	@Id
	private int tid; // 试卷编号
	@Column
	private String tname; // 试卷名称
	@Column
	private int state; // 试卷状态
	@Column
	private int tsum; // 试卷总分
	@Column
	private int time; // 该试卷的考试时长
	@Column
	private String tdate; // 该试卷生成时间

	@Column
	@Readonly
	private String uname;	
	@Column
	@Readonly
	private int sid;
	@Column
	@Readonly
	private String sname;
	@Column
	@Readonly
	private int gid;
	@Column
	@Readonly
	private String gname;
	@Column
	@Readonly
	private String qsname;

	private List<TestQuestionDomain> questionList;

	public TestDomain() {

	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
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

	public String getTdate() {
		return tdate;
	}

	public void setTdate(String str) {
		this.tdate = str;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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

	public String getQsname() {
		return qsname;
	}

	public void setQsname(String qsname) {
		this.qsname = qsname;
	}

	public List<TestQuestionDomain> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<TestQuestionDomain> questionList) {
		this.questionList = questionList;
	}

	public TestDomain(int tid, String tname, int state, int tsum, int time, String tdate, String uname, int sid,
			String sname, int gid, String gname, String qsname, List<TestQuestionDomain> questionList) {
		this.tid = tid;
		this.tname = tname;
		this.state = state;
		this.tsum = tsum;
		this.time = time;
		this.tdate = tdate;
		this.uname = uname;
		this.sid = sid;
		this.sname = sname;
		this.gid = gid;
		this.gname = gname;
		this.qsname = qsname;
		this.questionList = questionList;
	}

	@Override
	public String toString() {
		return "TestDomain [tid=" + tid + ", tname=" + tname + ", state=" + state + ", tsum=" + tsum + ", time=" + time
				+ ", tdate=" + tdate + ", uname=" + uname + ", sid=" + sid + ", sname=" + sname + ", gid=" + gid
				+ ", gname=" + gname + ", qsname=" + qsname + ", questionList=" + questionList + "]";
	}

}

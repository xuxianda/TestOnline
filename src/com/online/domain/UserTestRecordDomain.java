package com.online.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;
import org.springframework.stereotype.Component;

@Table("usertest_db")
@View("usertest")
@Component
public class UserTestRecordDomain {
	@Id
	private int testid;
	@Column
	private int uid;
	@Column
	private int tid;
	@Column
	private int score;
	@Column
	private String date;
	@Column
	private int state;
	@Column
	@Readonly
	private String uname; // 用户名称
	@Column
	@Readonly
	private String tname;// 试卷名称
	@Column
	@Readonly
	private int tsum;// 试卷分数
	@Column
	@Readonly
	private int time;// 试卷时间

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getTestid() {
		return testid;
	}

	public void setTestid(int testid) {
		this.testid = testid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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

	public int gettime() {
		return time;
	}

	public void settime(int time) {
		this.time = time;
	}

	public UserTestRecordDomain(int testid, int uid, int tid, int score, String date, int state) {
		super();
		this.testid = testid;
		this.uid = uid;
		this.tid = tid;
		this.score = score;
		this.date = date;
		this.state = state;
	}

	public UserTestRecordDomain() {
		super();
	}

	@Override
	public String toString() {
		return "UserTestRecordDomain [testid=" + testid + ", uid=" + uid + ", tid=" + tid + ", score=" + score
				+ ", date=" + date + ", state=" + state + ", uname=" + uname + ", tname=" + tname + ", tsum=" + tsum
				+ ", TIME=" + time + "]";
	}

	

}

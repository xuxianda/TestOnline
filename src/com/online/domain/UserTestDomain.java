package com.online.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.View;
@View("usertest_all")
public class UserTestDomain {
	@Column
	@Readonly
	private int tid; 	//试卷编号
	@Column
	@Readonly
	private String tname;	//试卷名称
	
	@Column
	@Readonly
	private String uname;
	
	@Column
	@Readonly
	private String date;
	
	@Column 
	@Readonly
	private String username;
	
	@Column
	@Readonly
	private int score;
	
	@Column
	@Readonly
	private int uid;
	
	@Column
	@Readonly
	private int time;
	
	@Column
	@Readonly
	private int testid;
	
	@Column
	@Readonly
	private int tsum;
	
	@Column
	@Readonly
	private int integral;
	
	@Column
	@Readonly
	private String gender;
	
	@Column
	@Readonly
	private int rank;

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

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public int getTestid() {
		return testid;
	}

	public void setTestid(int testid) {
		this.testid = testid;
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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UserTestDomain [tid=" + tid + ", tname=" + tname + ", uname=" + uname + ", date=" + date + ", username="
				+ username + ", score=" + score + ", uid=" + uid + ", time=" + time + ", testid=" + testid + ", tsum="
				+ tsum + ", integral=" + integral + ", gender=" + gender + ", rank=" + rank + "]";
	}

	
	

}

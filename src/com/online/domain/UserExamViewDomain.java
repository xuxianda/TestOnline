package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.View;

@View("userexam_view")
public class UserExamViewDomain {
	public UserExamViewDomain() {

	}

	public UserExamViewDomain(int uid, String uname, String username, String password, String gender, int intrgral,
			int state, int testid, String date, int score, int tid, String tname, int tsum) {
		this.uid = uid;
		this.uname = uname;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.intrgral = intrgral;
		this.state = state;
		this.testid = testid;
		this.date = date;
		this.score = score;
		this.tid = tid;
		this.tname = tname;
		this.tsum = tsum;
	}

	@Column
	@Readonly
	private int uid;
	@Column
	@Readonly
	private String uname;
	@Column
	@Readonly
	private String username;
	@Column
	@Readonly
	private String password;
	@Column
	@Readonly
	private String gender;
	@Column
	@Readonly
	private int intrgral;
	@Column
	@Readonly
	private int state;
	@Column
	@Readonly
	private int testid;
	@Column
	@Readonly
	private String date;
	@Column
	@Readonly
	private int score;
	@Column
	@Readonly
	private int tid;
	@Column
	@Readonly
	private String tname;
	@Column
	@Readonly
	private int tsum;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getIntrgral() {
		return intrgral;
	}

	public void setIntrgral(int intrgral) {
		this.intrgral = intrgral;
	}

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

	public int getTsum() {
		return tsum;
	}

	public void setTsum(int tsum) {
		this.tsum = tsum;
	}

	@Override
	public String toString() {
		return "UserExamViewDomain [uid=" + uid + ", uname=" + uname + ", username=" + username + ", password="
				+ password + ", gender=" + gender + ", intrgral=" + intrgral + ", state=" + state + ", testid=" + testid
				+ ", date=" + date + ", score=" + score + ", tid=" + tid + ", tname=" + tname + ", tsum=" + tsum + "]";
	}

}

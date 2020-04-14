package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

/**
 * 用户实体类
 * 
 * @author 许显达
 *
 */
@Table("user_db")
@View("user_role")
public class UserDomain {
	@Id
	private int uid; // 用户编号
	@Column
	private String username; // 帐号
	@Column
	private String password;// 密码
	@Column
	private String uname;// 用户名称
	@Column
	private char gender;// 用户性别，男和女
	@Column
	private int integral;// 用户积分，默认为0
	@Column
	private int state;// 用户状态：0为待审核，-1为禁用，1为启用

	@Column
	@Readonly
	private int rid;

	@Column
	@Readonly
	private String rname;

	public UserDomain() {
	}

	public UserDomain(int uid, String username, String password, String uname, char gender, int integral, int state) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.uname = uname;
		this.gender = gender;
		this.integral = integral;
		this.state = state;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "UserDomain [uid=" + uid + ", username=" + username + ", password=" + password + ", uname=" + uname
				+ ", gender=" + gender + ", integral=" + integral + ", state=" + state + ", rid=" + rid + ", rname="
				+ rname + "]";
	}

}

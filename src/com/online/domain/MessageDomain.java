package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Readonly;
import org.nutz.dao.entity.annotation.Table;
import org.nutz.dao.entity.annotation.View;

@Table("message_db")
@View("user_message")
public class MessageDomain {

	public MessageDomain() {
	}

	@Id
	private int mid;

	@Column
	private String message;

	@Column
	private String date;

	@Column
	@Readonly
	private String username;
	@Column
	@Readonly
	private String uname;
	@Column
	@Readonly
	private String rname;

	@Column
	@Readonly
	private int uid;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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

	public MessageDomain(int mid, String message, String date, String username, String uname, String rname, int uid) {
		super();
		this.mid = mid;
		this.message = message;
		this.date = date;
		this.username = username;
		this.uname = uname;
		this.rname = rname;
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "MessageDomain [mid=" + mid + ", message=" + message + ", date=" + date + ", username=" + username
				+ ", uname=" + uname + ", rname=" + rname + ", uid=" + uid + "]";
	}

}

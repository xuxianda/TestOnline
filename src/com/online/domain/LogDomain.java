package com.online.domain;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;
@Table("log_db")
public class LogDomain {
	private int lid;
	private String username;
	private String operation;
	private String method;
	private String params;
	private String ip;
	private String createDate;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	@Override
	public String toString() {
		return "LogDomain [lid=" + lid + ", username=" + username + ", operation=" + operation + ", method=" + method
				+ ", params=" + params + ", ip=" + ip + ", createDate=" + createDate + "]";
	}
	
	

}

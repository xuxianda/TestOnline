package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;
import org.springframework.stereotype.Component;

@Table("userquest_usertest_db")
@Component
public class UserQuestAndUserTestDomain {
	@Column	
	private int testid;
	@Column	
	private int uqid;
	public int getTestid() {
		return testid;
	}
	public void setTestid(int testid) {
		this.testid = testid;
	}
	public int getUqid() {
		return uqid;
	}
	public void setUqid(int uqid) {
		this.uqid = uqid;
	}
	@Override
	public String toString() {
		return "UserQuestAndUserTestDomain [testid=" + testid + ", uqid=" + uqid + "]";
	}
	
}

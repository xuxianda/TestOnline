package com.online.domain;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Table;

/**
 * 用户公告关联表
 * @author chenmei
 *
 */
@Table("user_announcement_db")
public class UserAnnouncementDomain {
	@Column
	private int aid;
	@Column
	private int uid;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

}

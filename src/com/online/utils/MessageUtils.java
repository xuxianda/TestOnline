package com.online.utils;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.domain.MessageDomain;

/**
 * 消息类
 * 
 * @author xxd
 *
 */
@Component
public class MessageUtils {
	@Autowired
	Dao dao;

	public MessageUtils() {
	}

	/**
	 * 获取聊天信息
	 * 
	 * @return 消息集合
	 */
	public List<MessageDomain> getMessage() {
		Pager pager = dao.createPager(1, 20);
		List<MessageDomain> list = dao.query(MessageDomain.class, Cnd.NEW().desc("mid"), pager);
		return list;
	}

	/**
	 * 发送消息
	 * 
	 * @param domain消息实体类
	 * @return true消息发送成功；false消息发送失败
	 */

	public boolean send(MessageDomain domain) {
		domain.setDate(TimeUtils.getCurrentDateTime());
		MessageDomain messageDomain = dao.insert(domain);
		if (messageDomain == null) {
			return false;
		}
		Sql sql = Sqls.create("insert into user_message_db value(@uid,@mid)");
		sql.setParam("uid", domain.getUid());
		sql.setParam("mid", messageDomain.getMid());
		dao.execute(sql);
		return true;
	}
}

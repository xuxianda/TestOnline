package com.online.dao.Impl;

import java.util.List;

import org.nutz.dao.Cnd;
import org.nutz.dao.QueryResult;
import org.nutz.dao.Sqls;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.dao.AnnouncementDao;
import com.online.domain.Announcement;
import com.online.domain.Page;
import com.online.domain.QuestionDomain;
import com.online.domain.UserAnnouncementDomain;
import com.online.domain.UserDomain;
import com.online.domain.UserTestDomain;
import com.online.utils.TimeUtils;

/**
 * 公告dao层实现类
 * 
 * @author Administrator
 *
 */
@Repository
public class AnnouncementDaoImpl implements AnnouncementDao {

	@Autowired
	private NutDao nutDao;

	@Override
	public Announcement addAnnouncement(int uid, Announcement announ) {
		announ.setAdate(TimeUtils.getCurrentDateTime());
		Announcement ann = nutDao.insert(announ);
		Sql sql = Sqls.create("INSERT INTO `user_announcement_db` (`uid`, `aid`) VALUES (@uid, @aid);");
		sql.setParam("uid", uid);
		sql.setParam("aid", ann.getAid());
		nutDao.execute(sql);
		return ann;
	}

	@Override
	public int delAnnouncementByAid(int aid) {
		Announcement p = nutDao.fetch(Announcement.class, Cnd.where("aid", "=", aid));
		p.setState(1);

		return nutDao.update(p);
	}

	@Override
	public int updateAnnouncement(Announcement announ) {
		// String time=TimeUtils.getCurrentDateTime();
		Announcement p = nutDao.fetch(Announcement.class, Cnd.where("aid", "=", announ.getAid()));
		System.out.println(p);
		String time = TimeUtils.getCurrentDateTime();
		p.setAdate(time);
		p.setAname(announ.getAname());
		p.setAuthor(announ.getAuthor());
		p.setAvalue(announ.getAvalue());
		return nutDao.update(p);
	}

	@Override
	public Page<Announcement> findAllAnnoucement(int indexpage, int pagesize) {
		Page<Announcement> page = new Page<Announcement>();
		Pager pager = nutDao.createPager(indexpage, pagesize);
		List<Announcement> list = nutDao.query(Announcement.class, Cnd.where("state", "=", 0).desc("adate"), pager);
		page.setTotal(nutDao.query(Announcement.class, Cnd.where("state", "=", 0)).size());
		page.setRows(list);
		int sumpage = page.getTotal() % pagesize == 0 ? page.getTotal() / pagesize : page.getTotal() / pagesize + 1;
		page.setSum(sumpage);
		return page;
	}

	@Override
	public Announcement findAnnouncementByAid(int aid) {
		return nutDao.fetch(Announcement.class, Cnd.where("aid", "=", aid).and("state", "=", 0));
	}

	@Override
	public boolean findByAid(int aid, int uid) {
		return nutDao.fetch(UserAnnouncementDomain.class, Cnd.where("aid", "=", aid).and("uid", "=", uid)) != null;
	}

}

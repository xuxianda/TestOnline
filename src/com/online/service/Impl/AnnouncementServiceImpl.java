package com.online.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.AnnouncementDao;
import com.online.dao.ExamDao;
import com.online.domain.Announcement;
import com.online.domain.Page;
import com.online.service.AnnouncementService;
/**
 * 公告ServiceImpl页面
 * @author chenmei
 *
 */

@Service
public class AnnouncementServiceImpl implements AnnouncementService{

	@Autowired
	AnnouncementDao announDao;
	@Override
	public Announcement addAnnouncementService(int uid,Announcement anno) {
		
		return announDao.addAnnouncement(uid,anno);
	}

	@Override
	public int delAnnouncementByAidService(int aid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAnnouncementService(Announcement announ) {
		// TODO Auto-generated method stub
		return announDao.updateAnnouncement(announ);
	}

	@Override
	public Page<Announcement> findAllAnnoucementService(int indexpage, int pagesize) {
		// TODO Auto-generated method stub
		return announDao.findAllAnnoucement(indexpage, pagesize);
	}

	@Override
	public Announcement findAnnouncementByAidService(int aid) {
		// TODO Auto-generated method stub
		return announDao.findAnnouncementByAid(aid);
	}

	@Override
	public boolean findByAidService(int aid, int uid) {
		
		return announDao.findByAid(aid, uid);
	}

}

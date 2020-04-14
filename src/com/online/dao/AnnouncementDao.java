package com.online.dao;

import java.util.List;

import com.online.domain.Announcement;
import com.online.domain.Page;

public interface AnnouncementDao {

	/**
	 * 增加公告
	 * @return
	 */
   public Announcement addAnnouncement(int aid,Announcement anno);
   
   /**
    * 通过公告编号删除公告
    * @return
    */
   public int delAnnouncementByAid(int aid);
   
   /**
    * 修改公告
    * @param announ 公告对象
    * @return
    */
   public int updateAnnouncement(Announcement announ);
   
   /**
    * 公告list集合
    * @return
    */
   public Page<Announcement> findAllAnnoucement(int indexpage, int pagesize);
   
  /**
   * 获得单个公告信息
   * @param aid 公共编号
   * @return
   */
   public Announcement findAnnouncementByAid(int aid);
   
   /**
    * 判断是否是该用户发布
    */
   public boolean findByAid(int aid,int uid);
}

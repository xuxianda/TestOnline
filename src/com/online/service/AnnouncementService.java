package com.online.service;

import java.util.List;

import com.online.domain.Announcement;
import com.online.domain.Page;

public interface AnnouncementService {


	/**
	 * 增加公告
	 * @return
	 */
   public Announcement addAnnouncementService(int uid,Announcement anno);
   
   /**
    * 通过公告编号删除公告
    * @return
    */
   public int delAnnouncementByAidService(int aid);
   
   /**
    * 修改公告
    * @param announ 公告对象
    * @return
    */
   public int updateAnnouncementService(Announcement announ);
   
   /**
    * 公告list集合
    * @return
    */
   public Page<Announcement> findAllAnnoucementService(int indexpage, int pagesize);
   
  /**
   * 获得单个公告信息
   * @param aid 公共编号
   * @return
   */
   public Announcement findAnnouncementByAidService(int aid);
   
   /**
    * 判断是否是该用户发布
    */
   public boolean findByAidService(int aid,int uid);
}

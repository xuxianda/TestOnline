package com.online.service;

import com.online.domain.Page;
import com.online.domain.UserQuestionsDomain;
import com.online.domain.UserTestRecordDomain;

/**
 * 试卷批阅service层接口
 * @author Administrator
 *
 */
public interface ExamsGradeService {
	/**
	 * 自动批阅选择题
	 * @param testid 考试编号
	 * @return
	 */
	public boolean ExamAuto(int testid);
	
	/**
	 * 校验考试是否存在
	 * @param testid
	 * @return
	 */
	public UserTestRecordDomain testCheck(int testid);
	
	/**
	 * 获取所有未批阅试卷
	 * @return
	 */
	public Page<UserTestRecordDomain> getTest(int page, int rows);
	
	/**
	 * 模糊查询未批阅试卷
	 * @param tname
	 * @param uname
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<UserTestRecordDomain> getTest(String tname,String uname,int page, int rows);
	
	/**
	 * 根据考试Id获取答题卡等题目信息
	 * @param testid
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<UserQuestionsDomain> getStudentKey(int testid,int page, int rows);
	
	/**
	 * 按题目类型获取答题卡题目
	 * @param testid
	 * @param tyid 题目类型
	 * @param page
	 * @param rows
	 * @return
	 */
	public Page<UserQuestionsDomain> getJ(int testid,int tyid,int page, int rows);
	
	/**
	 * 修改考试分数
	 * @param testid
	 * @param score
	 * @return
	 */
	public boolean update(int testid ,int score);
}

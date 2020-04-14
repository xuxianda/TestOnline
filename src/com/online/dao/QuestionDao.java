package com.online.dao;

import java.util.List;

import org.nutz.dao.QueryResult;

import com.online.domain.GradeDomain;
import com.online.domain.Page;
import com.online.domain.QuestionDomain;
import java.util.List;

public interface QuestionDao {
	/**
	 * 添加题目
	 * 
	 * @param questionDomain题目对象
	 * @param gid
	 *            等级id
	 * @param sid
	 *            科目id
	 * @param tid
	 *            类型id
	 * @return int 返回自增长id
	 */
	int add(int uid,QuestionDomain questionDomain);

	/**
	 * 停用题目
	 * 
	 * @param questionDomain
	 *            题目对象
	 * @return int 返回变化的行数
	 */
	int stop(QuestionDomain questionDomain);

	/**
	 * 修改题目
	 * 
	 * @param questionDomain
	 *            题目对象
	 * @return int 返回变化的行数
	 */
	int update(QuestionDomain questionDomain);
	/**
	 * 查询所有题目
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return 题目list集合
	 */
	Page<QuestionDomain> find(int indexpage,int pagesize);
	
	/**
	 * 根据题目查询
	 * @param qname 题目
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return 题目list集合
	 */
	Page<QuestionDomain> find1(String qname,int indexpage,int pagesize);
	/**
	 * 据题目，科目查询
	 * @param qname 题目
	 * @param sid 科目id
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return 题目list集合
	 */
	Page<QuestionDomain> find2(String qname,int sid,int indexpage,int pagesize);
	/**
	 * 根据题目，科目，等级查询
	 * @param qname 题目
	 * @param sid 科目id
	 * @param gid 等级id
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return 题目list集合
	 */
	Page<QuestionDomain> find3(String qname,int sid,int gid,int indexpage,int pagesize);
	/**
	 * 根据科目查询
	 * @param sid 科目id
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return 题目list集合
	 */
	Page<QuestionDomain> find4(int sid,int indexpage,int pagesize);
	/**
	 * 根据科目，等级查询
	 * @param sid 科目id
	 * @param gid 等级 id
	 * @param indexpage 页数
	 * @param pagesize	每页显示的条数
	 * @return 题目list集合
	 */
	Page<QuestionDomain> find5(int sid,int gid,int indexpage,int pagesize);
	/**
	 * 根据等级查询
	 * @param gid 等级 id
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return 题目list集合
	 */
	Page<QuestionDomain> find6(int gid,int indexpage,int pagesize);
	/**
	 * 根据题目，等级查询
	 * @param qname 题目
	 * @param gid 等级id
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return 题目list集合
	 */
	Page<QuestionDomain> find7(String qname,int gid,int indexpage,int pagesize);
	
	/**
	 * 查询老师自己出的题目
	 * @param uid 用户id
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return 题目list集合
	 */
	List<QuestionDomain> MyQuestion(int uid,int indexpage,int pagesize);
	
	/**
	 * 查询未审核的题目
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return list集合
	 */
	List<QuestionDomain> getNo(int indexpage,int pagesize);
	
	/**
	 * 查询已审核的题目
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return list集合
	 */
	List<QuestionDomain> getYes(int indexpage,int pagesize);
	
	/**
	 * 查询已禁用的题目
	 * @param indexpage 页数
	 * @param pagesize 每页显示的条数
	 * @return list集合
	 */
	List<QuestionDomain> getStop(int indexpage,int pagesize);
	
	/**
	 * 修改题目为已审核状态
	 * @param questionDomain 题目对象
	 * @return 
	 */
	int updateYesState(int qid);
	
	/**
	 * 修改题目为禁用状态
	 * @param questionDomain 题目对象
	 * @return
	 */
	int updateStopState(int qid);
	
	/**
	 * 根据题目id查询单个题目
	 * @param qname
	 * @return
	 */
	QuestionDomain getBeanQuestion(int qid);

}

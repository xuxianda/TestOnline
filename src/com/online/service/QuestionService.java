package com.online.service;

import java.util.List;

import com.online.domain.Page;
import com.online.domain.QuestionDomain;
import java.util.List;

public interface QuestionService {

	int add(int uid, QuestionDomain questionDomain);

	int stop(QuestionDomain questionDomain);

	int update(QuestionDomain questionDomain);

	Page<QuestionDomain> find(int indexpage, int pagesize);

	// 根据题目查询
	Page<QuestionDomain> find1(String qname, int indexpage, int pagesize);

	// 根据题目，科目查询
	Page<QuestionDomain> find2(String qname, int sid, int indexpage, int pagesize);

	// 根据题目，科目，等级查询
	Page<QuestionDomain> find3(String qname, int sid, int gid, int indexpage, int pagesize);

	// 根据科目查询
	Page<QuestionDomain> find4(int sid, int indexpage, int pagesize);

	// 根据科目，等级查询
	Page<QuestionDomain> find5(int sid, int gid, int indexpage, int pagesize);

	// 根据等级查询
	Page<QuestionDomain> find6(int gid, int indexpage, int pagesize);

	// 根据题目，等级查询
	Page<QuestionDomain> find7(String qname, int gid, int indexpage, int pagesize);

	List<QuestionDomain> MyQuestion(int uid, int indexpage, int pagesize);

	List<QuestionDomain> getNo(int indexpage, int pagesize);

	List<QuestionDomain> getYes(int indexpage, int pagesize);

	List<QuestionDomain> getStop(int indexpage, int pagesize);
	
	boolean updateYesState(int qid);
	boolean updateStopState(int qid);
	QuestionDomain getBeanQuestion(int qid);

}

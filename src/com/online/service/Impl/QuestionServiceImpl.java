package com.online.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.QuestionDao;
import com.online.domain.Page;
import com.online.domain.QuestionDomain;
import com.online.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionDao questionDao;

	@Override
	public int add(int uid,QuestionDomain questionDomain) {
		return questionDao.add(uid,questionDomain);
	}

	@Override
	public int stop(QuestionDomain questionDomain) {
		return questionDao.stop(questionDomain);
	}

	@Override
	public int update(QuestionDomain questionDomain) {
		return questionDao.update(questionDomain);
	}
	

	@Override
	public Page<QuestionDomain> find(int indexpage,int pagesize) {
		System.out.println(questionDao);
		return questionDao.find(indexpage,pagesize);
	}

	@Override
	public Page<QuestionDomain> find1(String qname, int indexpage, int pagesize) {
		return questionDao.find1(qname, indexpage, pagesize);
	}

	@Override
	public Page<QuestionDomain> find2(String qname, int sid, int indexpage, int pagesize) {
		return questionDao.find2(qname, sid, indexpage, pagesize);
	}

	@Override
	public Page<QuestionDomain> find3(String qname, int sid, int gid, int indexpage, int pagesize) {
		return questionDao.find3(qname, sid, gid, indexpage, pagesize);
	}

	@Override
	public Page<QuestionDomain> find4(int sid, int indexpage, int pagesize) {
		return questionDao.find4(sid, indexpage, pagesize);
	}

	@Override
	public Page<QuestionDomain> find5(int sid, int gid, int indexpage, int pagesize) {
		return questionDao.find5(sid, gid, indexpage, pagesize);
	}

	@Override
	public Page<QuestionDomain> find6(int gid, int indexpage, int pagesize) {
		return questionDao.find6(gid, indexpage, pagesize);
	}

	@Override
	public Page<QuestionDomain> find7(String qname, int gid, int indexpage, int pagesize) {
		return questionDao.find7(qname, gid, indexpage, pagesize);
	}

	@Override
	public List<QuestionDomain> MyQuestion(int uid, int indexpage, int pagesize) {
		return questionDao.MyQuestion(uid, indexpage, pagesize);
	}

	@Override
	public List<QuestionDomain> getNo(int indexpage, int pagesize) {
		return questionDao.getNo(indexpage, pagesize);
	}

	@Override
	public List<QuestionDomain> getYes(int indexpage, int pagesize) {
		return questionDao.getYes(indexpage, pagesize);
	}

	@Override
	public List<QuestionDomain> getStop(int indexpage, int pagesize) {
		return questionDao.getStop(indexpage, pagesize);
	}

	@Override
	public boolean updateYesState(int qid) {
		return questionDao.updateYesState(qid)>0;
	}

	@Override
	public boolean updateStopState(int qid) {
		return questionDao.updateStopState(qid)>0;
	}

	@Override
	public QuestionDomain getBeanQuestion(int qid) {
		return questionDao.getBeanQuestion(qid);
	}

	

}

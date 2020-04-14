package com.online.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.SubjectDao;
import com.online.domain.Page;
import com.online.domain.SubjectDomain;
import com.online.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;
	
	@Override
	public Page<SubjectDomain> findAll(int page, int rows) {
		return subjectDao.findAll(page,rows);
	}

	@Override
	public boolean add(SubjectDomain domain) {
		return subjectDao.add(domain);
	}

	@Override
	public boolean update(SubjectDomain domain) {
		return subjectDao.update(domain);
	}

	@Override
	public List<SubjectDomain> findAll2() {
		return subjectDao.findAll2();
	}

}

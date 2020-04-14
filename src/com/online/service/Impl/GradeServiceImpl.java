package com.online.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.dao.GradeDao;
import com.online.domain.GradeDomain;
import com.online.service.GradeService;
@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDao gradeDao;
	
	@Override
	public List<GradeDomain> findAll() {
		return gradeDao.findAll();
	}

}

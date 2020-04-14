package com.online.service;

import java.util.List;

import com.online.dao.GradeDao;
import com.online.domain.GradeDomain;

public interface GradeService {
	
	List<GradeDomain> findAll();
}

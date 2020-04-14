package com.online.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.dao.UserExamViewDao;
import com.online.domain.Page;
import com.online.domain.UserExamViewDomain;
import com.online.service.UserExamViewService;

@Component
public class UserExamViewServiceImpl implements UserExamViewService {

	@Autowired
	private UserExamViewDao viewDao;

	public UserExamViewServiceImpl() {
	}

	@Override
	public Page<UserExamViewDomain> find(String type, String value,int page,int rows) {
		return viewDao.find(type, value,page,rows);
	}

}

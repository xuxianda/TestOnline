package com.online.service;

import java.util.List;

import com.online.domain.Page;
import com.online.domain.UserExamViewDomain;

/**
 * 用户试卷列表业务层
 * 
 * @author xxd
 *
 */
public interface UserExamViewService {

	Page<UserExamViewDomain> find(String type, String value,int page,int rows);
}

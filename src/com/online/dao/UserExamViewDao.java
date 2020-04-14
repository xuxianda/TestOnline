package com.online.dao;

import java.util.List;

import com.online.domain.Page;
import com.online.domain.UserExamViewDomain;

/**
 * 用户考试列表
 * 
 * @author xxd
 *
 */
public interface UserExamViewDao {

	Page<UserExamViewDomain> find(String type, String value,int page,int rows);
}

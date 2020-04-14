package com.online.dao;

import com.online.domain.QuestionDomain;
import com.online.domain.SubjectDomain;
import com.online.domain.TestDomain;
import com.online.domain.TestQuestionDomain;
import com.online.domain.UserDomain;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface IPaperDao {


    /**
     * 默认查询所有试卷
     * @param
     * @return 试卷属性类
     */
    List<TestDomain> paperFindAll();

    /**
     * 按科目标准查询
     * 返回该类型所有试卷
     */
    List<TestDomain> findTypeAll(String tname);

    /**
     * 按名称模糊查询
     * 返回该类型所有试卷
     */
    List<TestDomain> findNameAll(String tname);
    
    /**
     * 按试卷编号查询
     * 返回该试卷题目
     */
    
    List<TestQuestionDomain> findQuestAll(int tid);
    
    

    /**
     * 添加试卷
     * @return 
     */
    TestDomain savePaper(TestDomain td,List<Integer> list,UserDomain user);

    /**
     * 修改试卷
     * @return 
     */
    int updatePaper(TestDomain td);
    
    
    /**
     * 审核试卷
     * @return 
     */
    int updateState(TestDomain td);
    
    /**
     * 修改试卷-添加题目
     * @return 
     */
    int updatePaperAdd(TestDomain td,List<Integer> list);
    
    /**
     * 修改试卷-删除题目
     * @return 
     */
    int updatePaperDel(TestDomain td,List<Integer> list);
    
    /**
     * 修改试卷-试卷启用
     * @return 
     */
    int updatePaperOpen(TestDomain tid); 


    /**
     * 停用试卷
     */
    int deletePaper(int tid);


    /**
     * 查询要审阅的试卷
     */
    List<TestDomain> tasterFindAll();


    /**
     * 对比试卷，按试卷科目查询试卷没有出现的题目
     */
    List<QuestionDomain> lastFindTQT(int tid,int sid);
    
    
    /**
     * 试卷录入题目，按科目、等级查询题目，题目状态必须为 1
     */
    List<QuestionDomain> findQuestType(int gid,int sid);
    
    


}
